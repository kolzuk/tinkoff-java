package edu.hw3;

public class Task4 {
    private enum RomanNumber {
        I(1), IV(4), V(5),
        IX(9), X(10), XL(40),
        L(50), XC(90), C(100),
        CD(400), D(500), CM(900),
        M(1000);
        final int weight;
        RomanNumber(int value) {
            this.weight = value;
        }
    }

    private Task4() {
    }

    public static String convertToRoman(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("Negative number");
        }

        int number = num;

        StringBuilder stringBuilder = new StringBuilder();

        final RomanNumber[] values = RomanNumber.values();

        for (int i = values.length - 1; i >= 0; --i) {
            while (number >= values[i].weight) {
                stringBuilder.append(values[i]);
                number -= values[i].weight;
            }
        }

        return stringBuilder.toString();
    }
}
