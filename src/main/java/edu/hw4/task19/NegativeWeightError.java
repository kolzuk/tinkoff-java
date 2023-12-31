package edu.hw4.task19;

import edu.hw4.Animal;

public class NegativeWeightError extends ValidationError {
    @Override
    public String getDescription() {
        return "Weight is negative number!";
    }

    @Override
    public boolean isValid(Animal animal) {
        return animal.weight() < 0;
    }
}
