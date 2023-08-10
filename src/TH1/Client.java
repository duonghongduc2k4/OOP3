package TH1;

import java.io.IOException;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        int serverPort = 6969;
        String serverIP = "localhost";

        DatagramSocket clientSocket = new DatagramSocket();

        String message = "hello Server!";
        byte[] sendData = message.getBytes();
        InetAddress serverAddress = InetAddress.getByName(serverIP);

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,serverAddress,serverPort);
        clientSocket.send(sendPacket);

        byte[] receiveData = new byte[1204];
        DatagramPacket serverPacket = new DatagramPacket(receiveData, receiveData.length);

        clientSocket.receive(serverPacket);

        String messageFromServer = new String(serverPacket.getData(), 0, serverPacket.getLength());

        System.out.println("Message from Server: "+ messageFromServer);

        clientSocket.close();
    }
}
