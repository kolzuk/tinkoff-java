package edu.hw3;

import java.util.ArrayList;

public class Task2 {
    private Task2() {
    }

    public static String[] clusterize(String parentheses) {
        ArrayList<String> parenthesesArray = new ArrayList<>();
        int balance = 0;

        int it1 = 0;
        int it2 = 0;
        while (it2 < parentheses.length()) {
            if (parentheses.charAt(it2) == '(') {
                balance++;
            } else if (parentheses.charAt(it2) == ')') {
                balance--;
            } else {
                throw new IllegalArgumentException("Not parentheses");
            }

            if (balance == 0) {
                parenthesesArray.add(parentheses.substring(it1, it2 + 1));
                it1 = it2 + 1;
            } else if (balance < 0) {
                throw new IllegalArgumentException("Not valid parentheses");
            }

            it2++;
        }

        return parenthesesArray.toArray(new String[0]);
    }
}
