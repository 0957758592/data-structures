package com.danilov.datastructures.queue;

public interface Queue {
    Object dequeue();
    void enqueue(Object value);
    int getSize();
}
