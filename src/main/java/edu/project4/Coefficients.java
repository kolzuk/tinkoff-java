package edu.project4;

import java.util.Random;

public class Coefficients {
    private static final Random randomGenerator = new Random();
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;
    public Coefficients() {
        do {
            this.a = (randomGenerator.nextDouble() - 0.5d) * 2;
            this.b = (randomGenerator.nextDouble() - 0.5d) * 2;
            this.c = (randomGenerator.nextDouble() - 0.5d) * 2;
            this.d = (randomGenerator.nextDouble() - 0.5d) * 2;
            this.e = (randomGenerator.nextDouble() - 0.5d) * 2;
            this.f = (randomGenerator.nextDouble() - 0.5d) * 2;
        } while (!((a * a + d * d < 1)
                && (b * b + e * e < 1)
                && (a * a + b * b + d * d + e * e < 1 + (a * e - b * d) * (a * e - b * d))));
    }

    public double a() {
        return a;
    }
    public double b() {
        return b;
    }
    public double c() {
        return c;
    }
    public double d() {
        return d;
    }
    public double e() {
        return e;
    }
    public double f() {
        return f;
    }
}
