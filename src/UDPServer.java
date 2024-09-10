import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) {

        int port = 5000;
        String hostname = "localhost";

        try {
            DatagramSocket socket = new DatagramSocket(5000);
            byte[] buffer = new byte[512];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String message = new String(packet.getData(),0, packet.getLength());
                System.out.println("besked modtaget" + message);
                String response = "echo" + message;
                byte[] responsebyte = response.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(responsebyte,responsebyte.length,packet.getAddress(), packet.getPort());
                socket.send(responsePacket);



            }



        } catch (IOException ex) {
            ex.printStackTrace();


        }
    }
}
