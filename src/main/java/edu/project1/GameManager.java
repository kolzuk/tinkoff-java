package edu.project1;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

public class GameManager {
    private @NotNull String answer;
    private int countOfFailAttempts;
    private final int maximumAttempts;
    private final char[] currentWord;

    public GameManager(String answer) {
        this.answer = answer;
        this.countOfFailAttempts = 0;
        this.maximumAttempts = answer.length();
        this.currentWord = new char[answer.length()];
        Arrays.fill(currentWord, '*');
    }

    public boolean canDoMove() {
        return countOfFailAttempts < maximumAttempts;
    }

    public boolean isVictory() {
        return canDoMove() && getCurrentWord().equals(answer);
    }

    public boolean isGuessed(char letter) {
        boolean isGuessed = false;
        for (int i = 0; i < answer.length(); ++i) {
            if (answer.charAt(i) == letter) {
                currentWord[i] = answer.charAt(i);
                isGuessed = true;
            }
        }

        if (!isGuessed) {
            countOfFailAttempts++;
        }

        return isGuessed;
    }

    public String getCurrentWord() {
        return new String(currentWord);
    }

    public int getCountOfAttempts() {
        return countOfFailAttempts;
    }

    public int getMaximumAttempts() {
        return maximumAttempts;
    }
}
