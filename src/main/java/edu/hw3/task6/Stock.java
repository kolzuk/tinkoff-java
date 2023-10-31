package edu.hw3.task6;

import org.jetbrains.annotations.NotNull;

public record Stock(String name, int price) implements Comparable<Stock> {
    @Override
    public int compareTo(@NotNull Stock o) {
        return o.price > this.price ? 1 : -1;
    }
}
