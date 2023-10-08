package edu.hw1;

import java.util.Arrays;
import java.util.Collections;

public final class Task6 {
    private static final int KAPREKAR_CONSTANT = 6174;
    private static final int NECESSARY_COUNT_OF_DIGIT = 4;
    private static final int NUMBER_BASE = 10;

    private Task6() {
    }

    public static int countK(int n) {
        return countK(n, 0);
    }

    private static int countK(int n, int countOfOperation) {
        int num = n;
        if (num == KAPREKAR_CONSTANT) {
            return countOfOperation;
        }

        Integer[] firstNum = new Integer[NECESSARY_COUNT_OF_DIGIT];
        Integer[] secondNum = new Integer[NECESSARY_COUNT_OF_DIGIT];

        for (int i = 0; i < NECESSARY_COUNT_OF_DIGIT; ++i) {
            firstNum[i] = num % NUMBER_BASE;
            secondNum[i] = num % NUMBER_BASE;
            num /= NUMBER_BASE;
        }

        Arrays.sort(firstNum);
        Arrays.sort(secondNum, Collections.reverseOrder());

        int iFirstNum = 0;
        int iSecondNum = 0;

        for (int i = 0; i < NECESSARY_COUNT_OF_DIGIT; ++i) {
            iFirstNum += (int) (firstNum[i]
                    * Math.pow(NUMBER_BASE, NECESSARY_COUNT_OF_DIGIT - i - 1));
            iSecondNum += (int) (secondNum[i]
                    * Math.pow(NUMBER_BASE, NECESSARY_COUNT_OF_DIGIT - i - 1));
        }

        return countK(iSecondNum - iFirstNum, countOfOperation + 1);
    }
}
