package second;
import java.io.*; 
public class TracerouteSimulator {
    public static void main(String[] a) throws Exception {
        String host = "google.com";
        System.out.println("Tracing route to " + host + "...\n");
        Process p = new ProcessBuilder("tracert", host).start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String l; while ((l = r.readLine()) != null) System.out.println(l);
        System.out.println("\nDone (exit " + p.waitFor() + ")");
    }
}