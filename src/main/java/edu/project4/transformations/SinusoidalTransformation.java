package edu.project4.transformations;

import edu.project4.Point;

public class SinusoidalTransformation implements ITransformation {
    @Override
    public Point apply(Point point) {
        double newX = Math.sin(point.x());
        double newY = Math.sin(point.y());

        return new Point(newX, newY);
    }
}
