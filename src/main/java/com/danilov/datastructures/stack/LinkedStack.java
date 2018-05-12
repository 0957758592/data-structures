package com.danilov.datastructures.stack;

import java.util.NoSuchElementException;

public class LinkedStack extends AbstractStack {

    Node tail;

    public void push(Object value) {
        validateValue(value);
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
            throw new NoSuchElementException("peek(): in LinkedStack");
        }
        validateValue(tail.value);
        return tail.value;
    }

    public Object pop() {
        if (size == 0 || tail == null) {
            throw new NoSuchElementException("poop(): in LinkedStack");
        } else {
            validateValue(tail.value);
            Object object = tail.value;
            tail = tail.prev;
            size--;
            return object;
        }
    }

    private class Node {

        Node prev;
        Object value;

        Node(Object value) {
            this.value = value;
        }

        Object getValue() {
            return value;
        }
    }

}
