package com.danilov.datastructures.stack;

import java.util.NoSuchElementException;

public class LinkedStack implements Stack {

    Node tail;
    int size;

    public void push(Object value) {
        Node newNode = new Node(value);
        if (size == 0) {
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public Object peek() {

        if (size == 0 || tail == null) {
            throw new NoSuchElementException("peek(): the LinkedStack is empty");
        }
        return tail.value;
    }

    public Object pop() {
        if (size == 0 || tail == null) {
            throw new NoSuchElementException("poop(): the LinkedStack is empty");
        } else {
            Object object = tail.value;
            tail = tail.prev;
            size--;
            return object;
        }
    }

    public int size() {
        return size;
    }
}
