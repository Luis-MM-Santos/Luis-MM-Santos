/*ExecutorService waitingConnection = Executors.newFixedThreadPool(4);
// block waiting for a client to connect
for(int i = 0; i < 10; i++){
    waitingConnection.submit(new ClientHandler(serverSocket, clientSocket));
System.out.println("Waiting for a client connection");
clientSocket = serverSocket.accept();
}*/
package io.codeforall.kernelfc;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.*;

public class Server {
    public static void main(String[] args) throws IOException {

        // STEP1: Get parameters from command line arguments
        int portNumber = 8686;
        ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
        ServerSocket serverSocket = new ServerSocket(portNumber);
        Socket clientSocket = null;


        ExecutorService waitingConnection = Executors.newCachedThreadPool();
        // block waiting for a client to connect
        System.out.println("A new chat has begun. Waiting for clients message!");

// STEP2: Bind to local port and block while waiting for client connections
        while (true) {
            System.out.println(Thread.currentThread().getName() + " Waiting for a client connection");
            clientSocket = serverSocket.accept();
            System.out.println(Thread.currentThread().getName() + " has connected");
            ClientHandler clientHandler = new ClientHandler(clientSocket);
            waitingConnection.submit(clientHandler);
            clientHandlers.add(clientHandler);
        }

    }


    public static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;
        String message;


        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;

            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        public void read() {
            try {
                message = in.readLine();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        public void write(){
            out.println(message);
            System.out.println(Thread.currentThread().getName() + " " + message);
        }

        @Override
        public void run() {
            while (true) {
                read();
                write();
            }
        }
    }

}
