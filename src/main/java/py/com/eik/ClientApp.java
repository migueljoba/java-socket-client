package py.com.eik;

import java.util.Random;

public class ClientApp {

    private static int port = 5555;

    public static void main(String[] args) {
        test_single_client();
    }

    public static void test_single_client() {
        EchoClient client = new EchoClient();
        client.startConnection("127.0.0.1", port);
        int i = 0;
        while (i< 1000) {
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
