package TH2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverIP = "localhost";
        int serverPort = 6969;

        DatagramSocket clientSocket = new DatagramSocket();

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap phep tinh (so_thu_1 operator so_thu_2)");

        String input = sc.nextLine();

        if ("exit".equalsIgnoreCase(input)) {
            clientSocket.close();
        }

        byte[] sendData = input.getBytes();
        InetAddress serverAddress = InetAddress.getByName(serverIP);

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,serverAddress,serverPort);
        clientSocket.send(sendPacket);



    }
}
