package com.danilov.datastructures.list;

public class Node {

    public Node next;
    public Node prev;
    public Object value;

    public Node(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

}
