package fourth;
import java.io.*; import java.net.*;
public class TCPClient {
    public static void main(String[] a) throws IOException {
        Socket s = new Socket("localhost", 1234);
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        System.out.print("Enter message: ");
        String msg = new BufferedReader(new InputStreamReader(System.in)).readLine();
        out.println(msg);
        System.out.println(in.readLine());
        s.close();
    }
}
