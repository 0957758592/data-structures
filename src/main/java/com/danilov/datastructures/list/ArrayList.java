package com.danilov.datastructures.list;

public class ArrayList extends AbstractList{

    private static final int INITIAL_CAPACITY = 5;
    private Object[] array;

    public ArrayList() {
        this(INITIAL_CAPACITY);
    }

    public ArrayList(int capacity) {
        array = new Object[capacity];
    }

    public void add(Object value, int index) {
        validateAddIndex(index);
        checkSize();
        System.arraycopy(array, index, array, index+1,(size++)-index);
        array[index] = value;
    }

    public Object remove(int index) {
        validateIndex(index);
        checkSize();
        Object removed = array[index];
        System.arraycopy(array, index+1, array, index, (size--)-index);
        return removed;
    }

    public Object get(int index) {
        validateIndex(index);
        return array[index];
    }

    public Object set(Object value, int index) {
        validateIndex(index);
        Object changed = array[index];
        array[index] = value;
        return changed;
    }

    public void clear() {
        for (int i = 0; i < size ; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public int indexOf(Object value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object value) {
        for (int i = size - 1; i >= 0; i--) {
            if (value.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    private void checkSize() {
        if (size == array.length) {
            Object[] newArray = new Object[(int) (array.length * 1.5)];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    public String toString() {
        String result = "[";

        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                result += array[i];
            } else {
                result += array[i] + ", ";
            }
        }
        result += "]";
        return result;
    }
}