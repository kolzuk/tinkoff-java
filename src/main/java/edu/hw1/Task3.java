package edu.hw1;

import java.util.Objects;

public final class Task3 {
    Task3() {
    }

    public static boolean isNestable(int[] firstArray, int[] secondArray) {
        Objects.requireNonNull(firstArray);
        Objects.requireNonNull(secondArray);

        if (firstArray.length == 0 || secondArray.length == 0) {
            return false;
        }

        int minFirstArray = Integer.MAX_VALUE;
        int maxFirstArray = Integer.MIN_VALUE;
        for (int value : firstArray) {
            minFirstArray = Math.min(minFirstArray, value);
            maxFirstArray = Math.max(maxFirstArray, value);
        }

        int minSecondArray = Integer.MAX_VALUE;
        int maxSecondArray = Integer.MIN_VALUE;
        for (int value : secondArray) {
            minSecondArray = Math.min(minSecondArray, value);
            maxSecondArray = Math.max(maxSecondArray, value);
        }

        return minFirstArray > minSecondArray
                && maxFirstArray < maxSecondArray;
    }
}
