/*ExecutorService waitingConnection = Executors.newFixedThreadPool(4);
// block waiting for a client to connect
for(int i = 0; i < 10; i++){
    waitingConnection.submit(new ClientHandler(serverSocket, clientSocket));
System.out.println("Waiting for a client connection");
clientSocket = serverSocket.accept();
}*/
package io.codeforall.kernelfc;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;

public class Server {
    public static void main(String[] args) throws IOException {
        ClientHandler clientHandler = null;
        // STEP1: Get parameters from command line arguments
        int portNumber = 8080;

        ServerSocket serverSocket = new ServerSocket(portNumber);

        Socket clientSocket = null;


        ExecutorService waitingConnection = Executors.newCachedThreadPool();
        // block waiting for a client to connect
        System.out.println("A new chat has begun. Waiting for clients message!");


// STEP2: Bind to local port and block while waiting for client connections
        for (int i = 0; i < 2; i++) {
            clientHandler = new ClientHandler(serverSocket, clientSocket);
            System.out.println("Waiting for a client connection");
            waitingConnection.submit(clientHandler);
            clientSocket = serverSocket.accept();
            System.out.println("I am Thread " + Thread.currentThread().getName() + " banana");
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String message = "hello";
        while (message != null) {
            try {
                message = in.readLine();
                if (message != null) {

                    System.out.println(Thread.currentThread().getName() + " said: " + message);
                }


            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        in.close();
        out.close();
        serverSocket.close();
        clientSocket.close();
        System.out.println("Chat has been closed");

// STEP4: Read from/write to the stream
    }

    private void close(Socket clientSocket) {

        try {
            clientSocket.close();

        } catch (IOException e) {

            System.out.println(e.getMessage());
        }

    }

    private void dispatch(Socket clientSocket) {

        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            close(clientSocket);
        } catch (SocketException ex) {

            System.out.println(ex.getMessage());

        } catch (IOException ex) {
            close(clientSocket);
        }


    }

    private class ClientDispatcher implements Runnable {

        private Socket socket;

        public ClientDispatcher(Socket socket) {
            this.socket = socket;
        }


        @Override
        public void run() {
            dispatch(socket);
        }
    }


}
