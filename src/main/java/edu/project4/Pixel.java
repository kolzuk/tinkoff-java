package edu.project4;

public class Pixel {
    public RGB rgb;
    public int hitCount;
    public double normal;
    public Pixel(int r, int g, int b, int hitCount) {
        rgb = new RGB(r, g, b);
        this.hitCount = hitCount;
    }

    public Pixel(Pixel other) {
        this.rgb = new RGB(other.rgb);
        this.hitCount = other.hitCount;
        this.normal = 0;
    }
}
