package edu.project1;

import java.util.Random;
import org.jetbrains.annotations.NotNull;

public class Dictionary {
    private static final Random RANDOMIZER = new Random();
    private static final String[] DICTIONARY = new String[] {"kolzuk"};

    private Dictionary() {}

    public @NotNull static String randomWord() {
        return DICTIONARY[Math.abs(RANDOMIZER.nextInt()) % DICTIONARY.length];
    }
}
