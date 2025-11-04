import java.io.*;

public class PT {
    public static void main(String[] args) {
        String host = "google.com";
        String cmd = System.getProperty("os.name").startsWith("Windows") ?
                "ping -n 4 " + host : "ping -c 4 " + host;

        try {
            Process p = Runtime.getRuntime().exec(cmd);
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line; boolean reachable = false;
            while ((line = r.readLine()) != null) {
                System.out.println(line);
                if (line.contains("Reply from") || line.contains("bytes from")) reachable = true;
            }
            System.out.println("\nResult: Host is " + (reachable ? "reachable." : "unreachable."));
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
