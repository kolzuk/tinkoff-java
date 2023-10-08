package edu.hw1;

import java.util.Arrays;
import java.util.Collections;

public final class Task6 {
    private static final int kaprekarNumber = 6174;

    private Task6() {
    }

    public static int countK(int n) {
        return countK(n, 0);
    }

    private static int countK(int n, int countOfOperation) {
        if (n == kaprekarNumber) {
            return countOfOperation;
        }

        Integer[] firstNum = new Integer[4];
        Integer[] secondNum = new Integer[4];

        for (int i = 0; i < 4; ++i) {
            firstNum[i] = n % 10;
            secondNum[i] = n % 10;
            n /= 10;
        }

        Arrays.sort(firstNum);
        Arrays.sort(secondNum, Collections.reverseOrder());

        int iFirstNum = 0;
        int iSecondNum = 0;

        for (int i = 0; i < 4; ++i) {
            iFirstNum += (int) (firstNum[i] * Math.pow(10, 3 - i));
            iSecondNum += (int) (secondNum[i] * Math.pow(10, 3 - i));
        }

        return countK(iSecondNum - iFirstNum, countOfOperation + 1);
    }
}
