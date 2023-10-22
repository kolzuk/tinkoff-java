package edu.project1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConsoleRunner {
    private final static Logger LOGGER = LogManager.getLogger();

    private ConsoleRunner() {}

    private static String readInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    public static void run() throws IOException {
        GameManager gameManager = new GameManager(Dictionary.randomWord());
        while (gameManager.canDoMove()
        && !gameManager.isVictory()) {
            String input = readInput();

            GameState response = GameRunner.nextMove(input, gameManager);

            switch (response) {
                case WRONG_INPUT:
                    LOGGER.info("Wrong input!");
                    break;
                case END:
                    return;
                case HIT:
                    LOGGER.info("Hit!");
                    break;
                case MISSED:
                    LOGGER.info("Missed, mistake "
                        + gameManager.getCountOfAttempts()
                        + " out of "
                        + gameManager.getMaximumAttempts());
                    break;
                default:
                    throw new IOException("Unfounded error");
            }

            LOGGER.info("The word: " + gameManager.getCurrentWord());
        }

        if (gameManager.isVictory()) {
            LOGGER.info("You win!");
        } else {
            LOGGER.info("You lost!");
        }
    }
}
