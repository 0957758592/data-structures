package com.danilov.datastructures.list;

public abstract class AbstractList implements List {
    int size;

    public void add(Object value) {
        add(value, size);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    public void validateAddIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index should be between 0 and " + (size) + " inclusive");
        }
    }

    public void validateIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Index should be between 0 and " + (size - 1) + " inclusive");
        }
    }

}
