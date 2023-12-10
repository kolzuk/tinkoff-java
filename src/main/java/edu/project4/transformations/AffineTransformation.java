package edu.project4.transformations;

import edu.project4.Coefficients;
import edu.project4.Point;
import edu.project4.RGB;

import java.util.Random;

public class AffineTransformation implements ITransformation {
    Random randomGenerator = new Random();
    Coefficients cf = new Coefficients();
    public final RGB rgb;
    public AffineTransformation() {
        this.rgb = new RGB(
                randomGenerator.nextInt(256),
                randomGenerator.nextInt(256),
                randomGenerator.nextInt(256));
    }

    @Override
    public Point apply(Point point) {
        double newX = cf.a() * point.x() + cf.b() * point.y() + cf.c();
        double newY = cf.d() * point.x() + cf.e() * point.y() + cf.f();

        return new Point(newX, newY);
    }
}
