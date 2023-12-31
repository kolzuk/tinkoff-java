package edu.hw4.task19;

import edu.hw4.Animal;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public final class Task19 {
    private static Set<ValidationError> errors;

    private Task19() {
        errors = new HashSet<>();
        errors.add(new EmptyNameError());
        errors.add(new NegativeAgeError());
        errors.add(new NegativeHeightError());
        errors.add(new NegativeWeightError());
    }

    public static Map<String, Set<ValidationError>> validateAnimals(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> errors.stream().anyMatch(error -> !error.isValid(animal)))
            .collect(Collectors.toMap(p -> p.name(), p -> errors.stream().filter(error -> !error.isValid(p)).collect(
                Collectors.toSet())));
    }
}
