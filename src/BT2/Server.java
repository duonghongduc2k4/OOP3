package BT2;

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
        byte[] bytes = new byte[2048];
        int IP = inputStream.read(bytes);
        String message = new String(bytes,0,IP);

    }
}
