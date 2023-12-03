package edu.hw8.Task1;

import java.io.*;
import java.net.Socket;

public class Client {
    private static Socket clientSocket;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) {
        try {
            try {
                clientSocket = new Socket("localhost", 8080);

                BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                while (true) {
                    String requestLine = consoleReader.readLine();

                    if (requestLine.equals("STOP")) {
                        break;
                    }

                    out.write(requestLine + '\n');
                    out.flush();

                    String response = in.readLine();
                    System.out.println(response);
                }
            } finally {
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
