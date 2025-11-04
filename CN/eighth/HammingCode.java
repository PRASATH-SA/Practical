package eighth;
import java.util.Scanner;

public class HammingCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 4-bit data: ");
        String data = sc.next();
        int[] code = encodeHamming(data);
        System.out.print("Transmitted Code: ");
        for (int b : code) System.out.print(b);

        System.out.print("\nEnter received 7-bit code: ");
        String r = sc.next();
        int err = detectError(r);
        System.out.println(err == 0 ? "No error detected." : "Error at position: " + err);
        sc.close();
    }

    static int[] encodeHamming(String d) {
        int[] c = new int[7];
        c[2]=d.charAt(0)-'0'; c[4]=d.charAt(1)-'0'; c[5]=d.charAt(2)-'0'; c[6]=d.charAt(3)-'0';
        c[0]=c[2]^c[4]^c[6]; c[1]=c[2]^c[5]^c[6]; c[3]=c[4]^c[5]^c[6];
        return c;
    }

    static int detectError(String r) {
        int p1=r.charAt(0)-'0'^r.charAt(2)-'0'^r.charAt(4)-'0'^r.charAt(6)-'0';
        int p2=r.charAt(1)-'0'^r.charAt(2)-'0'^r.charAt(5)-'0'^r.charAt(6)-'0';
        int p4=r.charAt(3)-'0'^r.charAt(4)-'0'^r.charAt(5)-'0'^r.charAt(6)-'0';
        return p1 + p2*2 + p4*4;
    }
}
