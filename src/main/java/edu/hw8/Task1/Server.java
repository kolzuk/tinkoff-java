package edu.hw8.Task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private static ArrayList<ClientRespondent> clientRespondents;
    private static ServerSocket serverSocket;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        serverSocket = new ServerSocket(8080);
        clientRespondents = new ArrayList<>();
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                try {
                    clientRespondents.add(new ClientRespondent(socket));
                } catch (Exception e) {
                    socket.close();
                }
            }
        } finally {
            serverSocket.close();
        }
    }
}
