package edu.project4.renderers;

import edu.project4.FractalImage;

public interface IFractalFlameRenderer {
    void render(FractalImage image, int samples, int iterationsPerSample);
}
