package edu.project4;

public class RGB {
    public int r;
    public int g;
    public int b;

    public RGB(RGB other) {
        this.r = other.r;
        this.g = other.g;
        this.b = other.b;
    }

    public RGB(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }
}
