package UDPchat;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverIP = "localhost";
        int serverPort = 6969;

        DatagramSocket clientSocket = new DatagramSocket();
        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();
        byte[] sendData = message.getBytes();

        InetAddress serverAddress =InetAddress.getByName(serverIP);
        DatagramPacket clientPacket = new DatagramPacket(sendData,sendData.length,serverAddress,serverPort);
        clientSocket.send(clientPacket);

        byte[] receiveData = new byte[1024];

        DatagramPacket serverPacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(serverPacket);

        String messageReceive = new String(serverPacket.getData(),0, serverPacket.getLength());
        System.out.println("Received from client: " + messageReceive);

        clientSocket.close();

    }
}
