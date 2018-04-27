package com.danilov.datastructures.stack;

public class Node {

    public Node prev;
    public Object value;

    public Node(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

}
