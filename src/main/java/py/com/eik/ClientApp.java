package py.com.eik;

import java.util.Random;
import java.util.Scanner;

public class ClientApp {

    public static void main(String[] args) {
        testSingleClient();
    }

    public static void testSingleClient() {
        EchoClient client = new EchoClient();
        String serverAddress = PropertiesLoader.getServerAddress();
        String serverPort = PropertiesLoader.getServerPort();
        client.startConnection(serverAddress, serverPort);

        String userInput = "";

        while (!".".equals(userInput)) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Ingresar cacracter: ");
            userInput =  sc.next();

            client.sendMessage(userInput + "|" + generateDataString());
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
