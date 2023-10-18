package edu.hw1;

public final class Task2 {
    private static final int NUMBER_BASE = 10;

    private Task2() {
    }

    public static int countDigits(int n) {
        int num = n;

        int ans = 0;
        do {
            num /= NUMBER_BASE;
            ans++;
        } while (num != 0);

        return ans;
    }
}
