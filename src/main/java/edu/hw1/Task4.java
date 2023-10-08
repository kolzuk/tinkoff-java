package edu.hw1;

import java.util.Objects;

public final class Task4 {
    private Task4() {
    }

    public static String fixString(String s) {
        Objects.requireNonNull(s);

        int n = s.length();

        char[] chars = s.toCharArray();

        for (int i = 0; i < n - n % 2; i += 2) {
            char tmp = chars[i];
            chars[i] = chars[i + 1];
            chars[i + 1] = tmp;
        }

        return new String(chars);
    }
}
