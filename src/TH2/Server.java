package TH2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        int serverPort = 6969;
        DatagramSocket serverSocket = new DatagramSocket(serverPort);
        System.out.println("Server is running...waiting client connect...");

        byte[] receiveData = new byte[1204];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        serverSocket.receive(receivePacket);
    }
}
