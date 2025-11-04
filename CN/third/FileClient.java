package third;
import java.io.*; import java.net.*;
public class FileClient {
    public static void main(String[] a) throws Exception {
        Socket s = new Socket("localhost", 1234);
        System.out.println("Connected.");
        try (InputStream in = s.getInputStream();
             OutputStream out = new FileOutputStream("received_file.txt")) {
            in.transferTo(out);
        }
        s.close();
        System.out.println("File received.");
    }
}
