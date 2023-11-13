package edu.project2.generators;

import edu.project2.Cell;
import edu.project2.Wall;

public class EllerGenerator extends MazeGenerator {
    private int uniqueSetNumber;
    private int[][] set;

    public EllerGenerator() {
    }

    private void generateRightWalls(int rowNumber) {
        for (int i = 0; i < m - 1; ++i) {
            boolean hasRightWall = RANDOM_NUMBER_GENERATOR.nextBoolean();

            if (hasRightWall
            || set[rowNumber][i] == set[rowNumber][i + 1]) {
                maze[rowNumber][i].addWall(Wall.RIGHT);
                maze[rowNumber][i + 1].addWall(Wall.LEFT);
            } else {
                int value = set[rowNumber][i + 1];
                for (int j = 0; j < m; ++j) {
                    if (set[rowNumber][j] == value) {
                        set[rowNumber][j] = set[rowNumber][i];
                    }
                }
            }
        }
    }

    private void generateDownWalls(int rowNumber) {
        if (rowNumber == n - 1) {
            return;
        }

        int it1 = 0;
        int it2 = 0;

        while (it2 < m) {
            while (it2 < m && set[rowNumber][it1] == set[rowNumber][it2]) {
                it2++;
            }

            int countOfSet = it2 - it1;

            if (countOfSet == 1) {
                it1 = it2;
                continue;
            }

            int countOfDownWalls = 0;
            while (it1 < m && it1 != it2) {
                boolean hasDownWall = RANDOM_NUMBER_GENERATOR.nextBoolean();

                if (hasDownWall
                        && countOfDownWalls != countOfSet - 1) {
                    maze[rowNumber][it1].addWall(Wall.DOWN);
                    maze[rowNumber + 1][it1].addWall(Wall.UP);
                    countOfDownWalls++;
                }

                it1++;
            }
        }
    }

    private void prepareRow(int currentRow) {
        for (int i = 0; i < m; ++i) {
            set[currentRow][i] = set[currentRow - 1][i];
        }

        for (int i = 0; i < m; ++i) {
            if (maze[currentRow - 1][i].hasWall(Wall.DOWN)) {
                set[currentRow][i] = ++uniqueSetNumber;
            }
        }
    }

    @Override
    public Cell[][] generate(int n, int m) {
        fillBorders(n, m);

        uniqueSetNumber = 0;
        set = new int[n][m];

        for (int i = 0; i < m; ++i) {
            set[0][i] = ++uniqueSetNumber;
        }

        for (int i = 0; i < n; ++i) {
            if (i > 0) {
                prepareRow(i);
            }

            generateRightWalls(i);
            generateDownWalls(i);
        }

        for (int i = 0; i < m - 1; ++i) {
            if (set[n - 1][i] != set[n - 1][i + 1]) {
                maze[n - 1][i].deleteWall(Wall.RIGHT);
                maze[n - 1][i + 1].deleteWall(Wall.LEFT);
            }
        }

        return maze;
    }
}
