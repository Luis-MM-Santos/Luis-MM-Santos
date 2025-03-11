package io.codeforall.kernelfc;

import java.io.*;
import java.net.*;


public class Client {
    public static void main(String[] args) throws IOException {


        // STEP1: Get the host and the port from the command-line
        String hostName = "localhost";
        int portNumber = 8686;

        // STEP2: Open a client socket, blocking while connecting to the server


        try {
            Socket serverSocket = new Socket(hostName, portNumber);
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(serverSocket.getOutputStream()));
            String message = "bolachas";

            while (message != null) {
                System.out.println("hw§before");
                    // read the pretended message from the console
                    message = in.readLine();
                System.out.println("hw§");
                    // write the pretended message to the output buffer
                    out.write(message);
                System.out.println("hw§ after");
                    out.newLine();
                    out.flush();
            }

            in.close();
            out.close();
            serverSocket.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
