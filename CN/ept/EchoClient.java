package ept;
import java.io.*; import java.net.*; import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 5000);
        System.out.println("Connected to Echo Server.");

        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter message: ");
        String msg = sc.nextLine();
        out.println(msg);
        System.out.println("Server response: " + in.readLine());

        s.close();
        sc.close();
    }
}
