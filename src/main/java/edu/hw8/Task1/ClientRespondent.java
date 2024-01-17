package edu.hw8.Task1;

import java.io.*;
import java.net.Socket;

public class ClientRespondent extends Thread {
    private final Socket CLIENT_SOCKET;
    private final BufferedReader IN;
    private final BufferedWriter OUT;
    private final String STOP_WORD = "STOP";
    private final String[] PHRASES = new String[]
            {"Не переходи на личности там, где их нет.",
            "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами.",
            "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.",
            "Чем ниже интеллект, тем громче оскорбления"};

    public ClientRespondent(Socket socket) throws IOException {
        this.CLIENT_SOCKET = socket;
        this.IN = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.OUT = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                String word = IN.readLine();

                if (word.equals(STOP_WORD)) {
                    break;
                }

                boolean isSend = false;
                for (String phrase : PHRASES) {
                    if (phrase.contains(word)) {
                        sendMessage(phrase);
                        isSend = true;
                        break;
                    }
                }

                if (!isSend) {
                    sendMessage("Не найдено совпадение");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void sendMessage(String message) {
        try {
            OUT.write(message + "\n");
            OUT.flush();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
