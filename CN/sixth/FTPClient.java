package sixth;
import java.io.*; import java.net.*;
public class FTPClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost",5000);
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter command (UPLOAD/DOWNLOAD): "); String cmd=br.readLine();
        dos.writeUTF(cmd);
        if(cmd.equalsIgnoreCase("UPLOAD")){
            System.out.print("Enter file path: "); String path=br.readLine();
            File file=new File(path);
            if(file.exists()){
                dos.writeUTF(file.getName());
                try(FileInputStream fis=new FileInputStream(file)){
                    byte[] buf=new byte[4096]; int n;
                    while((n=fis.read(buf))!=-1) dos.write(buf,0,n);
                }
                System.out.println("File uploaded!");
            } else System.out.println("File not found!");
        } else if(cmd.equalsIgnoreCase("DOWNLOAD")){
            System.out.print("Enter filename: "); String f=br.readLine();
            dos.writeUTF(f);
            if(dis.readUTF().equals("FILE_EXISTS")){
                try(FileOutputStream fos=new FileOutputStream("downloaded_"+f)){
                    byte[] buf=new byte[4096]; int n;
                    while((n=dis.read(buf))!=-1) fos.write(buf,0,n);
                }
                System.out.println("File downloaded!");
            } else System.out.println("File not found on server!");
        }
        s.close();
    }
}
