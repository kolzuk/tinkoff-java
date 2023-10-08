package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Task0 {
    private final static Logger LOGGER = LogManager.getLogger();

    Task0() {
    }

    public static void sayHello() {
        LOGGER.info("Hello world!");
    }
}
