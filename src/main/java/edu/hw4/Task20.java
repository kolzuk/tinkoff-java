package edu.hw4;

import edu.hw4.task19.*;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public final class Task20 {

    private Task20() {
    }

    public static Map<String, String> validateAnimals(List<Animal> animals) {
        return Task19.validateAnimals(animals)
            .entrySet()
            .stream()
            .collect(Collectors.toMap(Map.Entry::getKey, p -> p.getValue().stream().map(ValidationError::getDescription)
                .collect(Collectors.joining(" "))));
    }
}
