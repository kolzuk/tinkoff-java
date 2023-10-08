package edu.hw1;

public final class Task2 {
    private Task2() {
    }

    public static int countDigits(int n) {
        return Integer.toString(Math.abs(n)).length();
    }
}
