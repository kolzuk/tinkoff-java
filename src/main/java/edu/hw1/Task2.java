package edu.hw1;

public final class Task2 {
    private Task2() {
    }

    public static int countDigits(int n) {
        int num = n;

        int ans = 0;
        do {
            num /= 10;
            ans++;
        } while (num != 0);

        return ans;
    }
}
