package edu.hw4.task19;

import edu.hw4.Animal;

public class NegativeAgeError extends ValidationError {
    @Override
    public String getDescription() {
        return "Age is negative number!";
    }

    @Override
    public boolean isValid(Animal animal) {
        return animal.age() < 0;
    }
}
