package UDPchat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        int ServerPort = 6969;

        DatagramSocket serverSocket = new DatagramSocket(ServerPort);
        System.out.println("Server is running and waiting for Client...");

        byte[] receiveData = new byte[1024];

        DatagramPacket serverPacket = new DatagramPacket(receiveData, receiveData.length);
        serverSocket.receive(serverPacket);

        String message = new String(serverPacket.getData(),0, serverPacket.getLength());
        System.out.println("Received from client: " + message);

        Scanner sc = new Scanner(System.in);
        String messageSend = sc.nextLine();
        byte[] sendData = messageSend.getBytes();

        InetAddress clientAddress = serverPacket.getAddress();
        int clientPort = serverPacket.getPort();

        DatagramPacket clientPacket = new DatagramPacket(sendData,sendData.length,clientAddress,clientPort);
        serverSocket.send(clientPacket);


        serverSocket.close();

    }
}
