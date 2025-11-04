package First;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
public class PingTest { 
    public static void main(String[] args) { 
        String host = "google.com"; // Replace with target IP/hostname 
        int pingCount = 4; // Number of ping requests 
        try { 
            // Construct the ping command based on OS 
            String pingCmd; 
            if (System.getProperty("os.name").startsWith("Windows")) { 
                pingCmd = "ping -n " + pingCount + " " + host; 
            } else { // Linux/Mac 
                pingCmd = "ping -c " + pingCount + " " + host; 
            } 
            // Execute the ping command 
            Process process = Runtime.getRuntime().exec(pingCmd); 
            BufferedReader reader = new BufferedReader(new 
InputStreamReader(process.getInputStream())); 
            String line; 
            boolean isReachable = false; 
            System.out.println("Pinging " + host + "...\n"); 
            while ((line = reader.readLine()) != null) { 
                System.out.println(line); 
                if (line.contains("Reply from") || line.contains("bytes from")) { 
                    isReachable = true; 
                } 
            } 
 
            // Check reachability 
            if (isReachable) { 
                System.out.println("\nResult: Host is reachable."); 
            } else { 
                System.out.println("\nResult: Host is unreachable."); 
            } 
            process.waitFor(); 
        } catch (IOException | InterruptedException e) { 
            System.err.println("Error: " + e.getMessage()); 
        } 
    } 
} 