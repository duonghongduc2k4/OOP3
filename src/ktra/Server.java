package ktra;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
       int serverPort = 6969;
        DatagramSocket serverSocket = new DatagramSocket(serverPort);
        System.out.println("Server is Running...!");

        while (true){
         byte[] messReceive = new byte[1203];
         DatagramPacket serPacket = new DatagramPacket(messReceive, messReceive.length);
         serverSocket.receive(serPacket);
         String messageFromClient = new String(serPacket.getData(),serPacket.getOffset(),serPacket.getLength());

         if ("exit".equalsIgnoreCase(messageFromClient)) {
          serverSocket.close();
          break;
         }
         System.out.println("message from client: "+messageFromClient);

         Scanner sc = new Scanner(System.in);
         System.out.println("Write: ");
         String message = sc.nextLine();


         byte[] messSend = message.getBytes();

         InetAddress clientAddress = serPacket.getAddress();
         int clientPort = serPacket.getPort();
         DatagramPacket clientPacket = new DatagramPacket(messSend, messSend.length,clientAddress,clientPort);
         serverSocket.send(clientPacket);

        }



    }
}
