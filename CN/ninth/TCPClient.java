package ninth;
import java.io.*; import java.net.*;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 6789);
        System.out.println("Connected to server...");
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        out.println("Hello from TCP Client!");
        System.out.println("Server Response: " + in.readLine());
        s.close();
    }
}
