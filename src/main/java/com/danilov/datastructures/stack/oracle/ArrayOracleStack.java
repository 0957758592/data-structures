package com.danilov.datastructures.stack.oracle;

import java.util.EmptyStackException;

public class ArrayOracleStack {

    private static final int CAPACITY = 5;
    private Object[] array;
    private int size;

    public ArrayOracleStack(int size) {
        array = new Object[size + 2];
    }

    public ArrayOracleStack() {
        this(CAPACITY);
    }

    public Object push(Object item) {
        array[size] = item;
        size++;
        if (size == array.length) {
            Object newArray[] = new Object[size + 1];
            System.arraycopy(array, 0, newArray, 0, size);
            newArray[size] = item;
            array = newArray;
        }
        return array[size];
    }

    public Object pop() {
        stackException();
        Object object = array[size - 1];
        size--;
        Object[] newArray = new Object[size];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
        return object;
    }

    public Object peek() {
        stackException();
        Object object = array[size - 1];
        return object;
    }

    public boolean empty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int search(Object o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public int getSize() {
        return size;
    }

    private void stackException() {
        if (empty()) {
            throw new EmptyStackException();
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                result.append(array[i]);
            } else {
                result.append(array[i] + ", ");
            }
        }
        result.append("]");
        return result.toString();
    }

}