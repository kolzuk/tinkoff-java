package edu.hw2.task2;

public class Rectangle {
    private final int width;
    private final int height;

    public Rectangle(int tmpWidth, int tmpHeight) {
        width = tmpWidth;
        height = tmpHeight;
    }

    public double area() {
        return width * height;
    }
}
