package edu.hw4.task19;

import edu.hw4.Animal;

public abstract class ValidationError {
    public abstract String getDescription();

    public abstract boolean isValid(Animal animal);
}
