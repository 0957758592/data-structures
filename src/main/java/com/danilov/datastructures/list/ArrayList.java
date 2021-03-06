package com.danilov.datastructures.list;

import java.util.Iterator;
import java.util.StringJoiner;

public class ArrayList extends AbstractList {

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
        validateValue(value);
        grow();
        System.arraycopy(array, index, array, index + 1, size - index);
        size++;
        array[index] = value;
    }

    public Object remove(int index) {
        validateIndex(index);
        Object removed = array[index];
        System.arraycopy(array, index + 1, array, index, (size - 1) - index);
        array[size - 1] = null;
        size--;
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
        for (Object o : array) {
            o = null;
        }
        size = 0;
    }

    public int indexOf(Object value) {
        int i = 0;
        if (value == null) {

            for (Object o : array) {
                if (o.equals(null)) {
                    return i;
                }
            }
        } else {

            for (Object o : array) {
                if (value.equals(o)) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object value) {
        if (value == null) {
            for (int i = 0; i < size; i++) {
                if (array[i].equals(null)) {
                    return i;
                }
            }

        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (value.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    private void grow() {
        if (size == array.length) {
            Object[] newArray = new Object[(int) (array.length * 1.5) + 1];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    public String toString() {
        StringJoiner sj = new StringJoiner(",", "[", "]");
        for (Object o : array) {
            sj.add((CharSequence) o);
        }
        return sj.toString();
    }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator {
        private int i = 0;

        @Override
        public boolean hasNext() {
            return i < size;
        }

        @Override
        public Object next() {
            int val = i;
            i++;
            return array[val];
        }
    }
}