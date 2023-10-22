package edu.project1;

public class GameRunner {
    private static final String GAME_STOP_COMMAND = "STOP";

    private GameRunner() {}

    public static GameState nextMove(String input, GameManager gameManager) {
        if (input.equals(GAME_STOP_COMMAND)) {
            return GameState.END;
        }

        if (input.length() != 1) {
            return GameState.WRONG_INPUT;
        }

        if (gameManager.isGuessed(input.charAt(0))) {
            return GameState.HIT;
        } else {
            return GameState.MISSED;
        }
    }
}
