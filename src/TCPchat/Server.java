package TCPchat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        int serverPort = 6969;
        ServerSocket serverSocket = new ServerSocket(serverPort);
        System.out.println("Server is running and waiting for connection...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected");
        while (true) {
            InputStream inputStream = socket.getInputStream();
            byte[] ReceiveData = new byte[1024];
            int ReadBytes = inputStream.read(ReceiveData);
            String message = new String(ReceiveData, 0, ReadBytes);
            if ("exit".equalsIgnoreCase(message)) {
                socket
                        .close();
                serverSocket.close();
                break;
            }
            System.out.println("Receive message from client: " + message);

            OutputStream outputStream = socket.getOutputStream();
            Scanner sc = new Scanner(System.in);
            System.out.println("output Data: ");
            String messageSend = sc.nextLine();
            outputStream.write(messageSend.getBytes());

        }
    }
}
