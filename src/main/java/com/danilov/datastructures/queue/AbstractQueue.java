package com.danilov.datastructures.queue;

import java.util.NoSuchElementException;

public abstract class AbstractQueue implements Queue {
    int size;

    public void validateValue(Object value) {
        if (value == null) {
            throw new NoSuchElementException("the value can't be null");
        }
    }

    public int getSize() {
        return size;
    }

}
