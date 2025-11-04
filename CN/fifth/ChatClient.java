package fifth;
import java.io.*;
import java.net.*;
import java.util.*;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);
        System.out.println("Connected to server.");

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
            System.out.println("\nServer: " + msg);
            if (msg.equalsIgnoreCase("exit")) System.exit(0);
        }
    }
}
