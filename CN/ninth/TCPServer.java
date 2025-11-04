package ninth;
import java.io.*; import java.net.*;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6789);
        System.out.println("TCP Server running...");
        while (true) {
            Socket s = server.accept();
            System.out.println("Client connected: " + s.getInetAddress());
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            String msg = in.readLine();
            System.out.println("Received: " + msg);
            out.println("Server Reply: " + msg.toUpperCase());
            s.close();
        }
    }
}
