package edu.hw5;

import java.util.StringJoiner;

public class Task6 {
    private Task6() {
    }

    public static boolean isSubSequence(String S, String T) {
        StringJoiner joiner = new StringJoiner(".*");
        joiner.add(S.subSequence(0, S.length()));

        String regex = ".*" + joiner.toString() + ".*";

        return T.matches(regex);
    }
}
