package sixth;
import java.io.*; import java.net.*;
public class FTPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("FTP Server started on port 5000...");
        while(true){
            Socket s = server.accept();
            System.out.println("Client connected: " + s.getInetAddress());
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            String cmd = dis.readUTF();
            if(cmd.equalsIgnoreCase("UPLOAD")){
                String f = dis.readUTF();
                try(FileOutputStream fos=new FileOutputStream(f)){
                    byte[] buf=new byte[4096]; int n;
                    while((n=dis.read(buf))!=-1) fos.write(buf,0,n);
                }
                System.out.println("File received: "+f);
            } else if(cmd.equalsIgnoreCase("DOWNLOAD")){
                String f = dis.readUTF(); File file = new File(f);
                if(file.exists()){
                    dos.writeUTF("FILE_EXISTS");
                    try(FileInputStream fis=new FileInputStream(file)){
                        byte[] buf=new byte[4096]; int n;
                        while((n=fis.read(buf))!=-1) dos.write(buf,0,n);
                    }
                    System.out.println("File sent: "+f);
                } else dos.writeUTF("FILE_NOT_FOUND");
            }
            s.close();
        }
    }
}
