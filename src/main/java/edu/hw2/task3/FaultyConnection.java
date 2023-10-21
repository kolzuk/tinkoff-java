package edu.hw2.task3;

import java.util.Random;

public class FaultyConnection implements Connection {
    private static final Random RANDOMAZER = new Random();

    @Override
    public void execute(String command) throws ConnectionException {
        if (RANDOMAZER.nextBoolean()) {
            throw new ConnectionException();
        }
    }

    @Override
    public void close() {
    }
}
