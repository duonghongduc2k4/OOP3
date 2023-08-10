package TH1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkingUseURL  {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://docs.google.com/document/d/1CVh1L-3_58Cn8cF2qpfXFpwK4BEQi_qSoFKqgw3r3RM/edit");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        while((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }
        bufferedReader.close();
    }
}
