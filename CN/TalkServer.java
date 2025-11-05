import java.io.*; import java.net.*;

public class TalkServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(7000);
        System.out.println("Talk Server started...");
        Socket s = server.accept();
        System.out.println("Client connected.");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader serverInput = new BufferedReader(new InputStreamReader(System.in));

        String clientMsg, serverMsg;
        while (true) {
            clientMsg = in.readLine();
            System.out.println("Client says: " + clientMsg);
            System.out.print("Server reply: ");
            serverMsg = serverInput.readLine();
            out.println(serverMsg);
        }
    }
}
