package py.com.eik;

import java.util.Random;

public class ClientApp {

    public static void main(String[] args) {
        test_single_client();
    }

    public static void test_single_client() {
        EchoClient client = new EchoClient();
        String serverAddress = PropertiesLoader.getServerAddress();
        String serverPort = PropertiesLoader.getServerPort();
        client.startConnection(serverAddress, serverPort);
        int i = 0;
        while (i < 100) {
            client.sendMessage(generateDataString());
            i++;
        }

        client.stopConnection();
    }

    public static String randomNumber() {
        Random rand = new Random();
        double randNumber = rand.nextDouble();
        return Double.toString(randNumber);
    }

    public static String generateDataString() {
        String dataString = String.format("%s|%s|%s|%s|%s|%s|%s|%s",
                randomNumber(), randomNumber(), randomNumber(), randomNumber(),
                randomNumber(), randomNumber(), randomNumber(), randomNumber());
        return dataString;
    }
}
