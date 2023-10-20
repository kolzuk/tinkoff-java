package edu.hw2.task3;

import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    private static final Random randomazer = new Random();
    @Override
    public Connection getConnection() {
        if (randomazer.nextInt() % 2 == 0) {
            return new StableConnection();
        } else {
            return new FaultyConnection();
        }
    }
}
