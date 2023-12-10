package edu.project4;

import edu.project4.renderers.FractalFlameRenderer;
import edu.project4.renderers.FractalMultiThreadedRenderer;
import edu.project4.renderers.IFractalFlameRenderer;
import edu.project4.utils.ImageProcessor;
import edu.project4.utils.LogarithmicGammaCorrectionOfImage;

public class Main {
    public static void main(String[] args) {
        ImageProcessor imageProcessor = new LogarithmicGammaCorrectionOfImage();


        // Without MultiThread
        IFractalFlameRenderer fractalFlameGenerator = new FractalFlameRenderer(20);
        long startTime = System.currentTimeMillis();
        FractalImage image = new FractalImage(1920, 1080);
        fractalFlameGenerator.render(image, 1000, 500);
        imageProcessor.process(image);
        Display.createImage(image, "/home/kolzuk/Desktop/", "image", ImageFormat.BMP);
        System.out.println("Result without multiThread: "
                + (System.currentTimeMillis() - startTime));

        // With MultiThread
        fractalFlameGenerator = new FractalMultiThreadedRenderer(20);
        startTime = System.currentTimeMillis();
        image = new FractalImage(1920, 1080);
        fractalFlameGenerator.render(image, 1000, 500);
        imageProcessor.process(image);
        Display.createImage(image, "/home/kolzuk/Desktop/", "image1", ImageFormat.BMP);
        System.out.println("Result with multiThread: "
                + (System.currentTimeMillis() - startTime));
    }
}
