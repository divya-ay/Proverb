package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class socketServerMain {
    public static final int PORT = 4444;
    public static final String ADDRESS = "127.0.0.1";
    public static void main (String[] args){
        try{
            InetAddress address = InetAddress.getByName(ADDRESS);
            try (ServerSocket serverSocket = new ServerSocket(PORT, 50, address)){
                System.out.printf("Awaiting connections on %s : %d\n", address.getHostAddress(), PORT);
                try (Socket clientSocket= serverSocket.accept()){
                    System.out.printf("[%s: %d] connected!\n",
                            clientSocket.getInetAddress().getHostName(),
                            clientSocket.getPort());
                try(
                        BufferedReader clientReader
                                = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        PrintWriter clientWriter = new PrintWriter(clientSocket.getOutputStream(), true)
                ){
                    String inputLine;
                    while((inputLine = clientReader.readLine())!=null) {
                        System.out.printf("[%s:%d] line received: %s! \n",
                                clientSocket.getInetAddress().getHostName(),
                                clientSocket.getPort(),
                                inputLine
                        );
                        clientWriter.println("ack: " + inputLine);
                    }
                }
                }
            }
        }catch (IOException ex){
            System.out.printf("IO Error: %s\n", ex.getMessage());

        }
    }
}
