package edu.project4.utils;

import edu.project4.FractalImage;
import edu.project4.Pixel;

public class LogarithmicGammaCorrectionOfImage implements ImageProcessor {
    @Override
    public void process(FractalImage image) {
        double max = 0;
        double gamma = 2.2;

        for (int i = 0; i < image.height; ++i) {
            for (int j = 0; j < image.width; ++j) {
                Pixel pixel = image.getPixel(j, i);
                if (pixel.hitCount != 0) {
                    pixel.normal = Math.log10(pixel.hitCount);

                    if (pixel.normal > max) {
                        max = pixel.normal;
                    }
                }
            }
        }

        for (int i = 0; i < image.height; ++i) {
            for (int j = 0; j < image.width; ++j) {
                Pixel pixel = image.getPixel(j, i);

                pixel.normal /= max;

                pixel.rgb.r = (int)(pixel.rgb.r * Math.pow(pixel.normal, (1d / gamma)));
                pixel.rgb.g = (int)(pixel.rgb.g * Math.pow(pixel.normal, (1d / gamma)));
                pixel.rgb.b = (int)(pixel.rgb.b * Math.pow(pixel.normal, (1d / gamma)));
            }
        }
    }
}
