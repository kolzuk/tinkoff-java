package edu.hw1;

public final class Task5 {
    private Task5() {
    }

    public static boolean isPalindromeDescendant(int n) {
        int num = n;
        while (!isPalindrome(num) && Task2.countDigits(num) >= 2) {
            num = getDescendant(num);
        }

        return isPalindrome(num) && Task2.countDigits(num) >= 2;
    }

    public static boolean isPalindrome(int number) {
        int num = number;
        if (num == 0) {
            return true;
        }

        num = (num < 0) ? -num : num;
        String stringNum = Integer.toString(num);

        int n = stringNum.length();

        for (int i = 0; i < n / 2; ++i) {
            if (stringNum.charAt(i) != stringNum.charAt(n - i - 1)) {
                return false;
            }
        }

        return true;
    }

    private static int getDescendant(int num) {
        StringBuilder descendant = new StringBuilder();
        String sNum = Integer.toString(num);

        int n = sNum.length();

        for (int i = 0; i < n - 1; i += 2) {
            char a = sNum.charAt(i);
            char b = sNum.charAt(i + 1);

            int ia = Character.getNumericValue(a);
            int ib = Character.getNumericValue(b);

            int c = ia + ib;

            descendant.append(Integer.toString(c));
        }

        return Integer.parseInt(descendant.toString());
    }
}
