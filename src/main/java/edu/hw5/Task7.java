package edu.hw5;

public final class Task7 {
    private static final String FIRST_REGEX = "[01]{2}0[01]*";
    private static final String SECOND_REGEX = "0[01]*0|1[01]*1";
    private static final String THIRD_REGEX = "[01]{1,3}";
    private Task7() {}

    public static boolean firstMatch(String value) {
        return value.matches(FIRST_REGEX);
    }

    public static boolean secondMatch(String value) {
        return value.matches(SECOND_REGEX) || value.length() == 1;
    }

    public static boolean thirdMatch(String value) {
        return value.matches(THIRD_REGEX);
    }
}
