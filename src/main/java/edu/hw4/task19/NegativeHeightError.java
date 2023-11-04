package edu.hw4.task19;

import edu.hw4.Animal;

public class NegativeHeightError extends  ValidationError {
    @Override
    public String getDescription() {
        return "Height is negative number!";
    }

    @Override
    public boolean isValid(Animal animal) {
        return animal.height() < 0;
    }
}
