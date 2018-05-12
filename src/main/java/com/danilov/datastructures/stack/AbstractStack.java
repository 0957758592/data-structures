package com.danilov.datastructures.stack;

public abstract class AbstractStack implements Stack {
    int size;

    public void validateValue(Object value) {
        if (value == null) {
            throw new IllegalArgumentException("the value can't be null");
        }
    }

    public int size() {
        return size;
    }
}
