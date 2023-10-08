package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.ArrayUtils;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        EvenArrayUtils.filter(new int[]{1, 2, 3});
    }

}
