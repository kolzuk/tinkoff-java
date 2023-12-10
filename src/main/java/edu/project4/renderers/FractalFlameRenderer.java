package edu.project4.renderers;

import edu.project4.FractalImage;
import edu.project4.Pixel;
import edu.project4.Point;
import edu.project4.RGB;
import edu.project4.transformations.AffineTransformation;
import edu.project4.transformations.ITransformation;
import edu.project4.transformations.SinusoidalTransformation;
import edu.project4.transformations.SphericalTransformation;
import edu.project4.utils.Randomizer;

import java.util.ArrayList;
import java.util.Random;

public class FractalFlameRenderer implements IFractalFlameRenderer {
    private final Random randomizer = new Random();
    private final ArrayList<AffineTransformation> affineTransformations = new ArrayList<>();
    private final ArrayList<ITransformation> nonLinealTransformations = new ArrayList<>();
    private final double xMin = -1.5;
    private final double xMax = 1.5;
    private final double yMin = -1.5;
    private final double yMax = 1.5;

    public FractalFlameRenderer(int countOfAffineTransformations) {
        for (int i = 0; i < countOfAffineTransformations; ++i) {
            affineTransformations.add(new AffineTransformation());
        }

        nonLinealTransformations.add(new SinusoidalTransformation());
    }

    public void render(FractalImage image, int samples, int iterationsPerSample) {
        for (int sample = 0; sample < samples; ++sample) {
            double x = Randomizer.nextDouble(xMin, xMax);
            double y = Randomizer.nextDouble(yMin, yMax);
            Point P = new Point(x, y);

            iteratePoint(image, P, iterationsPerSample);
        }
    }

    private void iteratePoint(FractalImage image, Point P, int iterationPerSample) {
        int height = image.height;
        int width = image.width;
        for (int step = -20; step < iterationPerSample; ++step) {
            for (var nonLinealTransformation : nonLinealTransformations) {
                int affineTransformationIndex = randomizer.nextInt(affineTransformations.size());
                AffineTransformation affineTransformation = affineTransformations.get(affineTransformationIndex);
                P = affineTransformation.apply(P);

                Point finalP = nonLinealTransformation.apply(P);

                double Xf = finalP.x();
                double Yf = finalP.y();

                int newX = width - (int) (((xMax - Xf) / (xMax - xMin)) * width);
                int newY = height - (int) (((yMax - Yf) / (yMax - yMin)) * height);

                if (step < 0 || Xf < xMin || Xf > xMax
                        || Yf < yMin || Yf > yMax
                        || newX >= width || newY >= height) {
                    continue;
                }

                Pixel pixel = image.getPixel(newX, newY);

                if (pixel.hitCount == 0) {
                    pixel.rgb = affineTransformation.rgb;
                } else {
                    RGB oldRGB = pixel.rgb;
                    RGB defaultRGB = affineTransformation.rgb;
                    int newR = (oldRGB.r + defaultRGB.r) / 2;
                    int newG = (oldRGB.g + defaultRGB.g) / 2;
                    int newB = (oldRGB.b + defaultRGB.b) / 2;

                    pixel.rgb = new RGB(newR, newG, newB);
                }

                pixel.hitCount++;
            }
        }
    }
}
