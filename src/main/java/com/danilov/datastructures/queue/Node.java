package com.danilov.datastructures.queue;

public class Node {

    public Node next;
    public Object value;

    public Node(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

}
