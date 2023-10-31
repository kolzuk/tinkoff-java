package edu.hw3.task8;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BackwardIterator<T> implements Iterator<T> {
    private final Object[] collection;
    private int currentIndex;

    public BackwardIterator(Collection<T> collection) {
        this.collection = collection.toArray();
        this.currentIndex = collection.size();
    }

    @Override
    public boolean hasNext() {
        return currentIndex > 0;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        currentIndex--;
        return (T) collection[currentIndex];
    }
}
