package edu.project4.transformations;

import edu.project4.Point;

public class SphericalTransformation implements ITransformation {
    @Override
    public Point apply(Point point) {
        double x = point.x();
        double y = point.y();

        double newX = x / (x * x + y * y);
        double newY = y / (x * x + y * y);

        return new Point(0.5 * newX, 0.5 * newY);
    }
}
