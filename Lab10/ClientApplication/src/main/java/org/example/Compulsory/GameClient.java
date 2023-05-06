package org.example.Compulsory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class GameClient {

    public static void main(String[] args) {

        String address = "127.0.0.1";
        int PORT = 8000;

        while (true){
            try {

                Socket socket = new Socket(address, PORT);
                PrintWriter pwOut = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader brIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter a command: ");
                String request = scanner.next();

                pwOut.println(request);
                if(request.equals("exit")){
                    System.exit(0);
                }

                String rsp = brIn.readLine();

                System.out.println(rsp);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
