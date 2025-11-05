import java.io.*;
import java.net.*;

public class PingServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Ping Server started...");
        Socket s = server.accept();
        System.out.println("Client connected.");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        String msg;
        while ((msg = in.readLine()) != null) {
            if (msg.equalsIgnoreCase("ping")) {
                out.println("pong");
                System.out.println("Ping received. Sent pong.");
            }
        }

        s.close();
        server.close();
    }
}