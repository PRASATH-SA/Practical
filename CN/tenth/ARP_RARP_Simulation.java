package tenth;
import java.util.*;
public class ARP_RARP_Simulation{
    static Map<String,String> a=new HashMap<>(),r=new HashMap<>();
    public static void main(String[] x){
        a.put("192.168.1.1","00:1A:2B:3C:4D:5E");
        a.put("192.168.1.2","00:2B:3C:4D:5E:6F");
        r.put("00:1A:2B:3C:4D:5E","192.168.1.1");
        r.put("00:2B:3C:4D:5E:6F","192.168.1.2");
        Scanner s=new Scanner(System.in);
        System.out.print("1.ARP 2.RARP> ");
        int c=s.nextInt();
        s.nextLine();
        System.out.println(c==1?"MAC:"+a.getOrDefault(s.nextLine(),"Not Found"):
                           c==2?"IP:"+r.getOrDefault(s.nextLine(),"Not Found"):"Invalid!");
    }
}
