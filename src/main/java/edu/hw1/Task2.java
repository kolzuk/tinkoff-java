package edu.hw1;

public final class Task2 {
    private Task2() {
    }

    public static int countDigits(int num) {
        if (num == 0) {
            return 1;
        }

        int countOfDigits = 0;

        while (num != 0) {
            num /= 10;
            countOfDigits++;
        }

        return countOfDigits;
    }
}
