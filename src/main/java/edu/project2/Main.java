package edu.project2;

import edu.project2.generators.EllerGenerator;
import edu.project2.passers.IdealMazePasser;

public class Main {
    public static void main(String[] args) {
        var maze = new Maze(30, 30, new EllerGenerator());
        maze.print();
        System.out.println();
        maze.printPassRoute(new IdealMazePasser(), 0, 0, 25, 20);
    }
}
