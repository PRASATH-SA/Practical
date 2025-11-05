import java.io.*; import java.net.*;

public class PingClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 6000);
        System.out.println("Connected to Ping Server.");

        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

        long start = System.currentTimeMillis();
        out.println("ping");
        if (in.readLine().equals("pong")) {
            long rtt = System.currentTimeMillis() - start;
            System.out.println("Ping successful. RTT: " + rtt + " ms");
        }

        s.close();
    }
}
