package edu.project2;

import edu.project2.generators.MazeGenerator;
import edu.project2.passers.MazePasser;

public class Maze {
    public final int n;
    public final int m;
    public final Cell[][] maze;

    public Maze(int n, int m, MazeGenerator mazeGenerator) {
        if (n < 0 || m < 0) {
            throw new IllegalArgumentException();
        }

        this.maze = mazeGenerator.generate(n, m);
        this.n = n;
        this.m = m;
    }

    private char[][] printableMaze() {
        char[][] printableMaze = new char[2 * n + 1][2 * m + 1];

        for (int i = 0; i < printableMaze.length; ++i) {
            for (int j = 0; j < printableMaze[0].length; ++j) {
                if (i % 2 == 0 || j % 2 == 0) {
                    printableMaze[i][j] = '▆';
                } else {
                    printableMaze[i][j] = ' ';
                }
            }
        }

        for (int i = 1; i < printableMaze.length; i += 2) {
            for (int j = 1; j < printableMaze[0].length; j += 2) {
                int realI = i / 2;
                int realJ = j / 2;

                if (!maze[realI][realJ].hasWall(Wall.UP)) {
                    printableMaze[i - 1][j] = ' ';
                }

                if (!maze[realI][realJ].hasWall(Wall.RIGHT)) {
                    printableMaze[i][j + 1] = ' ';
                }

                if (!maze[realI][realJ].hasWall(Wall.DOWN)) {
                    printableMaze[i + 1][j] = ' ';
                }

                if (!maze[realI][realJ].hasWall(Wall.LEFT)) {
                    printableMaze[i][j - 1] = ' ';
                }
            }
        }

        return printableMaze;
    }

    public void print() {
        var maze = printableMaze();

        for (int i = 0; i < maze.length; ++i) {
            for (int j = 0; j < maze[0].length; ++j) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

    public void printPassRoute(MazePasser mazePasser, int xStart, int yStart,
                               int xEnd, int yEnd) {
        var route = mazePasser.passMaze(maze, xStart, yStart, xEnd, yEnd);

        var printableMaze = printableMaze();

        for (int i = 0; i < route.length; ++i) {
            int x = route[i].x();
            int y = route[i].y();

            printableMaze[2 * x + 1][2 * y + 1] = 'X';
        }

        for (int i = 0; i < printableMaze.length; ++i) {
            for (int j = 0; j < printableMaze[0].length; ++j) {
                System.out.print(printableMaze[i][j]);
            }
            System.out.println();
        }
    }
}
