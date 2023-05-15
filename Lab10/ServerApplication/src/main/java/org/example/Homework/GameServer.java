package org.example.Homework;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    private static final int PORT = 8000;
    private Game game;

    public GameServer() {
        game = new Game(15, "Player1", "Player2", 600);
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started at port " + PORT);
            while (true){
                Socket socket = serverSocket.accept();
                new ClientThread(socket, game).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        GameServer gameServer = new GameServer();
    }
}
