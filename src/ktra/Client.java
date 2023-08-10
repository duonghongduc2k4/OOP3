package ktra;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverIP = "localhost";
        int serverPort = 6969
                 ;

        DatagramSocket clientSocket = new DatagramSocket();
     while (true){


         Scanner sc = new Scanner(System.in);
         System.out.println("Write: ");
         String message = sc.nextLine();

         byte[] messSend = message.getBytes();
         InetAddress serverAddress = InetAddress.getByName(serverIP);
         DatagramPacket clientPacket = new DatagramPacket(messSend, messSend.length,serverAddress,serverPort);
         clientSocket.send(clientPacket);
         if ("exit".equalsIgnoreCase(message)) {
             clientSocket.close();
             break;
         }
         byte[] messReceive = new byte[1203];
         DatagramPacket receivePacket = new DatagramPacket(messReceive, messReceive.length);
         clientSocket.receive(receivePacket);
         String messageFromClient = new String(receivePacket.getData(),0,receivePacket.getLength());

         System.out.println("message from server: "+messageFromClient);

     }

    }
}
