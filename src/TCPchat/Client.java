package TCPchat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverIP = "localhost";
        int serverPort = 6969;

        Socket socket = new Socket(serverIP,serverPort);
        while (true) {
            OutputStream outputStream = socket.getOutputStream();
            Scanner sc = new Scanner(System.in);
            System.out.println("output Data: ");
            String messageSend = sc.nextLine();
            outputStream.write(messageSend.getBytes());
            if ("exit".equalsIgnoreCase(messageSend)) {
                socket.close();
                break;
            }

            InputStream inputStream = socket.getInputStream();
            byte[] ReceiveData = new byte[1024];
            int ReadBytes = inputStream.read(ReceiveData);
            String messageReceive = new String(ReceiveData, 0, ReadBytes);
            System.out.println("Receive message from client: " + messageReceive);


        }
    }
}
