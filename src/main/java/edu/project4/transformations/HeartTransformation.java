package edu.project4.transformations;

import edu.project4.Point;

public class HeartTransformation implements ITransformation {
    @Override
    public Point apply(Point point) {
        double x = point.x();
        double y = point.y();

        double r = Math.sqrt(x * x + y * y);

        double newX = r * Math.sin(r * Math.atan(y /x));
        double newY = r * Math.cos(r * Math.atan(y /x));

        return new Point(newX, newY);
    }
}
