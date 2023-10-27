package edu.hw3;

import java.util.HashMap;
import java.util.Map;

public class Task3 {
    private Task3() {
    }

    public static Map<String, Integer> freqDict(String[] words) {
        var dict = new HashMap<String, Integer>();

        for (int i = 0; i < words.length; ++i) {
            dict.merge(words[i], 1, Integer::sum);
        }

        return dict;
    }
}
