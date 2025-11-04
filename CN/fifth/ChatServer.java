package fifth;
import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Waiting for client...");
        Socket socket = server.accept();
        System.out.println("Client connected.");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        Scanner sc = new Scanner(System.in);

        // Send messages
        new Thread(() -> {
            while (true) {
                System.out.print("Enter your message: ");
                String msg = sc.nextLine();
                out.println(msg);
                if (msg.equalsIgnoreCase("exit")) System.exit(0);
            }
        }).start();

        // Receive messages
        String msg;
        while ((msg = in.readLine()) != null) {
            System.out.println("\nClient: " + msg);
            if (msg.equalsIgnoreCase("exit")) System.exit(0);
        }
    }
}
