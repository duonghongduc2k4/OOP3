package BT1;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        int serverPort = 6969;
        ServerSocket serverSocket = new ServerSocket(serverPort);
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1204];
        int data1 = inputStream.read(bytes);
        String number1 = new String(bytes,0,data1);

        int data2 = inputStream.read(bytes);
        String number2 = new String(bytes,0,data2);


        int sum = Integer.parseInt(number1) + Integer.parseInt(number2);

        System.out.println("tong 2 so: " +sum);

        serverSocket.close();
        socket.close();
    }

}
