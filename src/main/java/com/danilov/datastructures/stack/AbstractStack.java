package com.danilov.datastructures.stack;

public abstract class AbstractStack implements Stack {
    int size;

    public void validateValue(Object value) {
        if (value == null) {
            throw new NullPointerException("the value is " + value + ". Check the data!");
        }
    }

    public int size() {
        return size;
    }
}
