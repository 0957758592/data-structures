package com.trubin.education.data_structures.stack;

import com.trubin.education.data_structures.Node;

public class LinkedStack {

    Node tail;
    int size;


    public void push(Object value) {

        Node newNode = new Node(value);
        if (size == 0) {
            tail = newNode;
        } else {
            newNode.next = tail;
            tail = newNode;
        }
        size++;
    }

    public Object peek() {

        if (size == 0 || tail == null) {
            throw new NullPointerException("the stack is empty");
        }
        return tail.value;
    }

    public Object pop() {
        if (size == 0 || tail == null) {
            throw new NullPointerException("the stack is empty");
        } else {
            Object object = tail.value;
            tail = tail.next;
            size--;
            return object;
        }
    }

}
