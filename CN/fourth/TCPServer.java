package fourth;
import java.io.*; import java.net.*;
public class TCPServer {
    public static void main(String[] a) throws IOException {
        ServerSocket ss = new ServerSocket(1234);
        System.out.println("Waiting...");
        Socket s = ss.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        String msg = in.readLine();
        System.out.println("Client: " + msg);
        out.println("Server reply: " + msg);
        s.close(); ss.close();
    }
}
