import java.net.*;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket server = new DatagramSocket(9876);
        System.out.println("UDP Server running...");
        byte[] buf = new byte[1024];

        while (true) {
            DatagramPacket recv = new DatagramPacket(buf, buf.length);
            server.receive(recv);
            String msg = new String(recv.getData(), 0, recv.getLength());
            System.out.println("Received: " + msg);

            String reply = "Server Reply: " + msg.toUpperCase();
            byte[] sendData = reply.getBytes();
            DatagramPacket send = new DatagramPacket(sendData, sendData.length,
                    recv.getAddress(), recv.getPort());
            server.send(send);
        }
    }
}
