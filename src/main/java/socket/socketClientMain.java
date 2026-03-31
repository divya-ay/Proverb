package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class socketClientMain {
    public static void main(String[] args){
        try {
            try(Socket clientSocket
                    = new Socket(SocketServerMain.ADDRESS, SocketServerMain.PORT)){
                try(
                        BufferedReader reader
                                = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)
                ){
                    writer.println("Hello from client");
                    String response = reader.readLine();
                    System.out.printf("Server responded: %s\n", response);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
