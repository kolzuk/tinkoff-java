package edu.project2;

public class Cell {
    private int value;
    private final int upWall = 0b0001;
    private final int rightWall = 0b0010;
    private final int downWall = 0b0100;
    private final int leftWall = 0b1000;
    public boolean isPartOfRoute;

    public Cell() {
        this.value = 0;
        isPartOfRoute = false;
    }

    public void addWall(Wall wall) {
        if (wall == Wall.UP) {
            value |= upWall;
        }
        if (wall == Wall.RIGHT) {
            value |= rightWall;
        }
        if (wall == Wall.DOWN) {
            value |= downWall;
        }
        if (wall == Wall.LEFT) {
            value |= leftWall;
        }
    }

    public void deleteWall(Wall wall) {
        if (wall == Wall.UP) {
            value &= ~upWall;
        }
        if (wall == Wall.RIGHT) {
            value &= ~rightWall;
        }
        if (wall == Wall.DOWN) {
            value &= ~downWall;
        }
        if (wall == Wall.LEFT) {
            value &= ~leftWall;
        }
    }

    public boolean hasWall(Wall wall) {
        if (wall == Wall.UP) {
            return (value & upWall) != 0;
        }
        if (wall == Wall.RIGHT) {
            return (value & rightWall) != 0;
        }
        if (wall == Wall.DOWN) {
            return (value & downWall) != 0;
        }
        if (wall == Wall.LEFT) {
            return (value & leftWall) != 0;
        }

        throw new IllegalArgumentException();
    }
}
