package com.danilov.datastructures.stack;

import java.util.NoSuchElementException;

public class ArrayStack extends AbstractStack {

    private static final int CAPACITY = 5;
    private Object[] array;

    public ArrayStack() {
        this(CAPACITY);
    }

    public ArrayStack(int capacity) {
        array = new Object[capacity];
    }

    public void push(Object value) {
        validateValue(value);
        if (size == array.length) {
            Object[] newArray = new Object[(int) (size * 1.5)];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
        array[size] = value;
        size++;
    }

    public Object peek() {
        if (size == 0 || array[size - 1] == null) {
            throw new NoSuchElementException("peek(): in ArrayStack");
        }
        return array[size - 1];
    }

    public Object pop() {
        if (size == 0 || array[size - 1] == null) {
            throw new NoSuchElementException("pop(): in ArrayStack");
        } else {
            Object removed = array[size - 1];
            array[size - 1] = null;
            size--;
            return removed;
        }
    }

}
