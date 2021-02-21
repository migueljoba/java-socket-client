package py.com.eik;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {

    private static final Logger LOG = LogManager.getLogger(EchoClient.class);

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String serverAddress, String port) {
        int portInt = Integer.parseInt(port);
        startConnection(serverAddress, portInt);
    }

    public void startConnection(String serverAddress, int serverPort) {
        try {
            clientSocket = new Socket(serverAddress, serverPort);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        } catch (IOException e) {
            LOG.debug("Error when initializing connection", e);
        }

    }

    public String sendMessage(String msg) {
        try {
            out.println(msg);
            return in.readLine();
        } catch (Exception e) {
            return null;
        }
    }

    public void stopConnection() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            LOG.debug("error when closing", e);
        }

    }
}