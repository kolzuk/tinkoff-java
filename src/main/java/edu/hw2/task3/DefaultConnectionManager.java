package edu.hw2.task3;

import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    private static final Random RANDOMAZER = new Random();

    @Override
    public Connection getConnection() {
        if (RANDOMAZER.nextBoolean()) {
            return new StableConnection();
        } else {
            return new FaultyConnection();
        }
    }
}
