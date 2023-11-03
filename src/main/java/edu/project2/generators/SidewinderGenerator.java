package edu.project2.generators;

import edu.project2.Cell;
import edu.project2.Wall;

public class SidewinderGenerator extends MazeGenerator {
    public SidewinderGenerator() {
    }

    @Override
    public Cell[][] generate(int n, int m) {
        fillBorders(n, m);

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                maze[i][j].addWall(Wall.UP);
                maze[i][j].addWall(Wall.RIGHT);
                maze[i][j].addWall(Wall.DOWN);
                maze[i][j].addWall(Wall.LEFT);
            }
        }

        this.n = n;
        this.m = m;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (i == 0 && j == m - 1) {
                    continue;
                }

                if (i == 0) {
                    maze[i][j].deleteWall(Wall.RIGHT);
                    maze[i][j + 1].deleteWall(Wall.LEFT);
                    continue;
                }

                if (j == m - 1) {
                    maze[i][j].deleteWall(Wall.UP);
                    maze[i - 1][j].deleteWall(Wall.DOWN);
                    continue;
                }

                boolean isUpDirection = RANDOM_NUMBER_GENERATOR.nextBoolean();

                if (isUpDirection) {
                    maze[i][j].deleteWall(Wall.UP);
                    maze[i - 1][j].deleteWall(Wall.DOWN);
                } else {
                    maze[i][j].deleteWall(Wall.RIGHT);
                    maze[i][j + 1].deleteWall(Wall.LEFT);
                }
            }
        }

        return maze;
    }
}
