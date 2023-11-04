package edu.hw4;

import java.util.Comparator;
import java.util.List;

public class Task2 {
    private Task2() {
    }

    public static List<Animal> sortByWeight(List<Animal> animals, int k) {
        return animals.stream()
                .sorted(Comparator.comparing(Animal::weight).reversed())
                .limit(k)
                .toList();

    }
}
