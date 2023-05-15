package org.example.Homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread{

    private Socket socket = null;
    private Game game;

    public ClientThread(Socket socket, Game game) {
        this.socket = socket;
        this.game = game;
    }

    @Override
    public void run(){
        try {

            BufferedReader brIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request = brIn.readLine();

            System.out.println("Server received the request: " + request);
            PrintWriter pwOut = new PrintWriter(socket.getOutputStream());

            if(request.equals("stop"))
            {
                String rsp = "Server stopped";
                pwOut.println(rsp);
                pwOut.flush();
                System.exit(0);
            }
            else if (request.equals("create game")) {
                pwOut.println("Game created");
                pwOut.flush();
                game.play();
                pwOut.println("Game ended");
                pwOut.flush();
            } else if (request.startsWith("submit move")) {

            } else {
                pwOut.println("Unknown command");
                pwOut.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
