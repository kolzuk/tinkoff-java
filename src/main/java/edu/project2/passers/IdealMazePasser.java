package edu.project2.passers;

import edu.project2.Cell;
import edu.project2.Point;
import edu.project2.Wall;
import java.util.Stack;

public class IdealMazePasser extends MazePasser {
    @Override
    public Point[] passMaze(Cell[][] maze, int xStart, int yStart,
                                int xEnd, int yEnd) {
        if (xStart < 0 || xStart >= maze.length
                || yStart < 0 || yStart >= maze[0].length
                || xEnd < 0 || xEnd >= maze.length
                || yEnd < 0 || yEnd >= maze[0].length) {
            throw new IllegalArgumentException();
        }

        int n = maze.length;
        int m = maze[0].length;

        boolean[][] was = new boolean[n][m];

        var route = new Stack<Point>();
        route.push(new Point(xStart, yStart));
        was[xStart][yStart] = true;

        while (route.peek().x() != xEnd
        || route.peek().y() != yEnd) {
            var point = route.peek();

            int x = point.x();
            int y = point.y();

            if (x > 0 && !maze[x][y].hasWall(Wall.UP)
            && !was[x - 1][y]) {
                route.push(new Point(x - 1, y));
                was[x - 1][y] = true;
            } else if (x < n - 1 && !maze[x][y].hasWall(Wall.DOWN)
                    && !was[x + 1][y]) {
                route.push(new Point(x + 1, y));
                was[x + 1][y] = true;
            } else if (y < m - 1 && !maze[x][y].hasWall(Wall.RIGHT)
                    && !was[x][y + 1]) {
                route.push(new Point(x, y + 1));
                was[x][y + 1] = true;
            } else if (y > 0 && !maze[x][y].hasWall(Wall.LEFT)
                    && !was[x][y - 1]) {
                route.push(new Point(x, y - 1));
                was[x][y - 1] = true;
            } else {
                route.pop();
            }
        }

        return route.toArray(new Point[0]);
    }
}
