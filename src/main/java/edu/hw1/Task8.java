package edu.hw1;

public final class Task8 {
    private final static int[][] knightShift
            = new int[][]
            {
                    {1, 2}, {1, -2},
                    {-1, 2}, {-1, -2},
                    {2, 1}, {2, -1},
                    {-2, 1}, {2, -1}
            };
    private final static int chessBoardSize = 8;

    private Task8() {
    }

    public static boolean knightBoardCapture(int[][] board) {
        for (int i = 0; i < chessBoardSize; ++i) {
            for (int j = 0; j < chessBoardSize; ++j) {
                if (board[i][j] == 1 &&
                        isKnightBeatOtherKnight(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isKnightBeatOtherKnight(int[][] board, int x, int y) {
        for (int[] knightShifts : knightShift) {
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
                && x < chessBoardSize && y < chessBoardSize;
    }
}
