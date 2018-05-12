package com.danilov.datastructures.queue;

public abstract class AbstractQueue implements Queue {
    int size;

    public void validateValue(Object value) {
        if (value == null) {
            throw new NullPointerException("the value is " + value + ". Check the data!");
        }
    }

    public int getSize() {
        return size;
    }

}
