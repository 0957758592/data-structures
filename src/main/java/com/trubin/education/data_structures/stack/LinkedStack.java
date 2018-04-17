package com.trubin.education.data_structures.stack;

import com.trubin.education.data_structures.Node;

public class LinkedStack {

    Node head;
    int size;

    public void push(Object value) {

        Node newNode = new Node(value);
        if (size == 0) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public Object peek() {

        if (size == 0 || head == null) {
            throw new NullPointerException("the stack is empty");
        }
        return head.value;
    }

    public Object pop() {
        if (size == 0 || head == null) {
            throw new NullPointerException("the stack is empty");
        } else {
            Object object = head.value;
            head = head.next;
            size--;
            return object;
        }
    }

}
