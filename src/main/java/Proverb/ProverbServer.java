package Proverb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ProverbServer implements Runnable{
    public static final int PORT = 4444;
    public static final String HOSTNAME = "127.0.0.1";
    public final Socket clientSocket;

    public ProverbServer(Socket clientSocket){this.clientSocket = clientSocket;}

    @Override
    public void run(){
        ProverbProtocol protocol = new ProverbProtocol();
        try(clientSocket){
            String hostname = clientSocket.getInetAddress().getHostName();
            int port = clientSocket.getPort();
            System.out.printf("[%s: %d] connected!\n", hostname, port);

            //clientInput -> stream of Data FROM the client
            // serverOutput -> stream of Data to the client

            try (BufferedReader clientInput = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter serverOutput = new PrintWriter(clientSocket.getOutputStream(), true)
            ){
                String userInput = null;
                String serverResponse;
                while ((serverResponse = protocol.processInput(userInput)) != null){
                    serverOutput.println(serverResponse);
                    if(ProverbProtocol.isEndGame(serverResponse))
                        break;
                    userInput = clientInput.readLine();
                    System.out.printf("# Received message from the client [%s: %d] %s\n", hostname, port, userInput);
                }
            }
        } catch (IOException e){
            System.out.printf("Server IO Error: %s\n", e.getMessage());
        }
    }
}
