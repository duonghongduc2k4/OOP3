package TH1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    public static void main(String[] args) throws IOException {
        int serverPort = 6969;

        DatagramSocket serverSocket = new DatagramSocket(serverPort);
        System.out.println("Server is running...");

        byte[] receiveData = new byte[1204];
        DatagramPacket serverPacket = new DatagramPacket(receiveData, receiveData.length);

        serverSocket.receive(serverPacket);

        String message = new String(serverPacket.getData(), 0, serverPacket.getLength());

        System.out.println("Message from Client: "+ message);

        String messageFromClient = "hello Client!";
        byte[] sendData = messageFromClient.getBytes();
        InetAddress clientAddress = serverPacket.getAddress();
        int clientPort = serverPacket.getPort();

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,clientAddress,clientPort);
        serverSocket.send(sendPacket);

        serverSocket.close();

    }
}
