package edu.project2.generators;

import edu.project2.Cell;
import edu.project2.Wall;
import java.util.Random;

public abstract class MazeGenerator {
    protected static final Random RANDOM_NUMBER_GENERATOR = new Random();
    protected Cell[][] maze;
    protected int n;
    protected int m;

    protected void fillBorders(int n, int m) {
        maze = new Cell[n][m];

        this.n = n;
        this.m = m;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                maze[i][j] = new Cell();
            }
        }


        for (int i = 0; i < n; ++i) {
            maze[i][0].addWall(Wall.LEFT);
            maze[i][m - 1].addWall(Wall.RIGHT);
        }

        for (int j = 0; j < m; ++j) {
            maze[0][j].addWall(Wall.UP);
            maze[n - 1][j].addWall(Wall.DOWN);
        }
    }

    public abstract Cell[][] generate(int n, int m);
}
