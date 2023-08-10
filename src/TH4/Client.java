package TH4;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverIP= "127.0.0.1";
        int serverPort = 8080;
        Socket socket = new Socket(serverIP, serverPort);
        OutputStream outputStream = socket.getOutputStream();
        String message = "Hello, server!";
        outputStream.write(message.getBytes());
        socket.close();
    }
}
