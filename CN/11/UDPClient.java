import java.net.*;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket client = new DatagramSocket();
        InetAddress serverIP = InetAddress.getByName("localhost");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter message: ");
        String msg = sc.nextLine();
        byte[] sendData = msg.getBytes();
        client.send(new DatagramPacket(sendData, sendData.length, serverIP, 9876));

        byte[] recvData = new byte[1024];
        DatagramPacket recv = new DatagramPacket(recvData, recvData.length);
        client.receive(recv);
        System.out.println("Server Response: " + new String(recv.getData(), 0, recv.getLength()));

        client.close();
        sc.close();
    }
}
