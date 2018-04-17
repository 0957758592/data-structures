package com.trubin.education.data_structures;

public class Node {

    public Node next;
    public Object value;

    public Node(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public Node() {

    }
}
