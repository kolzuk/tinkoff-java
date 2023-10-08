package edu.hw1;

public final class Task7 {
    private Task7() {
    }

    public static int rotateLeft(int num, int shift) {
        int maxNumberSize = 1;
        int numBitSize = 1;
        while (maxNumberSize <= num && numBitSize < 32) {
            maxNumberSize *= 2;
            numBitSize++;
        }

        for (int i = 0; i < shift; ++i) {
            boolean hasHeadBit = ((maxNumberSize / 2) & num) > 0;

            num *= 2;

            if (hasHeadBit) {
                num = num & (maxNumberSize - 1);
                num += 1;
            }
        }

        return num;
    }

    public static int rotateRight(int num, int shift) {
        int maxNumberSize = 1;
        int numBitSize = 0;
        while (maxNumberSize <= num && numBitSize < 32) {
            maxNumberSize *= 2;
            numBitSize++;
        }

        for (int i = 0; i < shift; ++i) {
            boolean isOdd = (num % 2 != 0);

            num /= 2;

            if (isOdd) {
                num += (int) Math.pow(2, numBitSize - 1);
            }
        }

        return num;
    }
}
