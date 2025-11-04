package First;
import java.io.*;

public class PT {
    public static void main(String[] args) {
        String cmd = "ping -n 4 google.com ";

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
