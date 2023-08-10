package BT1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverIp = "127.0.0.1";
        int serverPort = 6969;

        Socket socket = new Socket(serverIp,serverPort);
        OutputStream outputStream = socket.getOutputStream();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so thu nhat: ");
        String num1 = sc.nextLine();
        System.out.println("Nhap so thu hai: ");
        String num2 = sc.nextLine();

        outputStream.write(num1.getBytes());
        outputStream.write(num2.getBytes());

        socket.close();

    }
}
