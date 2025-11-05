import java.io.*; import java.net.*; import java.util.Scanner;

public class TalkClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 7000);
        System.out.println("Connected to Talk Server.");

        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        Scanner sc = new Scanner(System.in);

        String userMsg, serverResp;
        while (true) {
            System.out.print("Client: ");
            userMsg = sc.nextLine();
            out.println(userMsg);
            serverResp = in.readLine();
            System.out.println("Server says: " + serverResp);
        }
    }
}
