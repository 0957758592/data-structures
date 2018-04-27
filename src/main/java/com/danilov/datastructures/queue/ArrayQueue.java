package com.danilov.datastructures.queue;

import java.util.NoSuchElementException;

public class ArrayQueue implements Queue {
    private int size;
    private static final int CAPACITY = 5;
    Object[] array;

    public ArrayQueue() {
        this(CAPACITY);
    }

    public ArrayQueue(int capacity) {
        array = new Object[capacity];
    }


    public void enqueue(Object value) {
        if(size == array.length){
            Object[] newArray = new Object[(int) (size*1.5)];
            System.arraycopy(array, 0 , newArray, 0, size);
            array = newArray;
        }
        array[size] = value;
        size++;
    }

    public Object dequeue() {
        Object removed = array[0];
        if (size > 0){
            System.arraycopy(array, 1, array, 0, size-1);
            size--;
        } else if (size == 0 && array[0] != null){
            array[0] = null;
        } else {
            throw new NoSuchElementException("deque() in ArrayQueue");
        }
        return removed;
    }

    public int getSize() {
        return size;
    }
}
