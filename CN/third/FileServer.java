package third;
import java.io.*; import java.net.*;
public class FileServer {
    public static void main(String[] a) throws Exception {
        ServerSocket ss = new ServerSocket(1234);
        System.out.println("Waiting...");
        Socket s = ss.accept();
        System.out.println("Client connected.");
        try (InputStream in = new FileInputStream("shared_file.txt");
             OutputStream out = s.getOutputStream()) {
            in.transferTo(out);
        }
        s.close(); ss.close();
        System.out.println("File sent.");
    }
}
