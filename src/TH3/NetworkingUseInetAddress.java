package TH3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkingUseInetAddress {

    public static void main(String[] args) throws IOException {
        InetAddress address = InetAddress.getByName("www.example.com");
        String ipAddress = address.getHostAddress();
        System.out.println("IP Address: "+ipAddress);

        String hostName = address.getHostName();
        System.out.println("Host Name: "+hostName);

        boolean reachable = address.isReachable(1000);
        System.out.println("Reachable: "+reachable);
    }
}
