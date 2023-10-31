package edu.hw3;

import java.util.HashMap;
import java.util.Map;

public class Task1 {
    private static final char[] ALPHABET = new char[]
            {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z'};

    private static final int ALPHABET_SIZE = 26;

    private static Map<Character, Character> symmetricSymbols = getFilledMap();

    private Task1() {
    }

    public static String atbash(String s) {
        char[] letters = s.toCharArray();


        for (int i = 0; i < letters.length; ++i) {
            if (symmetricSymbols.containsKey(letters[i])) {
                letters[i] = symmetricSymbols.get(letters[i]);
            }
        }

        return new String(letters);
    }

    private static Map<Character, Character> getFilledMap() {
        Map<Character, Character> symbols = new HashMap<>();

        for (int i = 0; i < ALPHABET.length; ++i) {
            char firstCharacter = ALPHABET[i];
            char secondCharacter = ALPHABET[ALPHABET_SIZE - i - 1];

            symbols.put(
                    firstCharacter,
                    secondCharacter);

            symbols.put(
                    Character.toUpperCase(firstCharacter),
                    Character.toUpperCase(secondCharacter));
        }

        return symbols;
    }
}
