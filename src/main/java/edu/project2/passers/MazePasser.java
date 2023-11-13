package edu.project2.passers;

import edu.project2.Cell;
import edu.project2.Point;

public abstract class MazePasser {
    public abstract Point[] passMaze(Cell[][] maze, int xStart,
                                     int yStart, int xEnd, int yEnd);
}
