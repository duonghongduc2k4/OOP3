package BT2;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class User {
    public static void main(String[] args) throws IOException {
        int serverPort = 6969;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ip vao: ");
        String serverIp = sc.nextLine();

        Socket socket = new Socket(serverIp,serverPort);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(serverIp.getBytes());

        socket.close();
    }
}
