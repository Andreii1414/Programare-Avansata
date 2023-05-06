package org.example.Compulsory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread {

    private Socket socket = null;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void start(){
        try {
            //request-ul de la input stream
            BufferedReader brIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request = brIn.readLine();

            System.out.println("Server received the request: " + request);

            if(request.equals("stop"))
            {
                PrintWriter pwOut = new PrintWriter(socket.getOutputStream());
                String rsp = "Server stopped";
                pwOut.println(rsp);
                pwOut.flush();
                System.exit(0);
            }
            else{
                PrintWriter pwOut = new PrintWriter(socket.getOutputStream());
                String rsp = "Server received the request...";
                pwOut.println(rsp);
                pwOut.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
