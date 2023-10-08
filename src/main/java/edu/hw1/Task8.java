package edu.hw1;

public final class Task8 {
    private final static int[][] KNIGHT_SHIFTS
            = new int[][]
            {
                    {1, 2}, {1, -2},
                    {-1, 2}, {-1, -2},
                    {2, 1}, {2, -1},
                    {-2, 1}, {2, -1}
            };
    private final static int CHESS_BOARD_SIZE = 8;

    private Task8() {
    }

    public static boolean knightBoardCapture(int[][] board) {
        for (int i = 0; i < CHESS_BOARD_SIZE; ++i) {
            for (int j = 0; j < CHESS_BOARD_SIZE; ++j) {
                if (board[i][j] == 1
                        && isKnightBeatOtherKnight(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isKnightBeatOtherKnight(int[][] board, int x, int y) {
        for (int[] knightShifts : KNIGHT_SHIFTS) {
            int xShift = knightShifts[0];
            int yShift = knightShifts[1];

            int nextXPosition = x + xShift;
            int nextYPosition = y + yShift;
            if (isRightPosition(nextXPosition, nextYPosition)
                    && board[nextXPosition][nextYPosition] == 1) {
                return true;
            }
        }

        return false;
    }

    private static boolean isRightPosition(int x, int y) {
        return x >= 0 && y >= 0
                && x < CHESS_BOARD_SIZE && y < CHESS_BOARD_SIZE;
    }
}
