package edu.project4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class Display {
    private final static Logger LOGGER = LogManager.getLogger();

    public static void createImage(FractalImage image, String path, String name, ImageFormat imageFormat) {
        int height = image.height;
        int width = image.width;

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                RGB rgb = image.getPixel(j, i).rgb;
                int rgbValue = (rgb.r << 16 | rgb.g << 8 | rgb.b);
                bufferedImage.setRGB(j, i, rgbValue);
            }
        }

        File outputImageFile = new File(Paths.get(path, name + "." + imageFormat.getFormat()).toString());

        try {
            ImageIO.write(bufferedImage, imageFormat.getFormat(), outputImageFile);
        } catch (IOException e) {
            LOGGER.error("Can`t write the image: " + name);
        }
    }
}
