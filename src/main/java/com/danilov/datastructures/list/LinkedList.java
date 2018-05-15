package com.danilov.datastructures.list;

import java.util.Iterator;
import java.util.StringJoiner;

public class LinkedList extends AbstractList {

    private Node head;
    private Node tail;

    public void add(Object value, int index) {
        validateAddIndex(index);
        validateValue(value);
        Node newNode = new Node(value);

        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            Node currNode = getNode(index);
            currNode.prev.next = newNode;
            newNode.next = currNode;
            newNode.prev = currNode.prev;
            currNode.prev = newNode;
        }
        size++;
    }

    public Object remove(int index) {
        validateIndex(index);
        Node currNode = getNode(index);
        Object removed = currNode.value;

        if (size == 1) {
            removed = head.value;
            head = tail = null;
        } else if (index == 0) {
            removed = head.value;
            head = head.next;
            head.prev = null;
        } else if (index == size - 1) {
            removed = tail.value;
            tail = tail.prev;
            tail.next = null;
        } else {
            currNode.prev.next = currNode.next;
            currNode.next.prev = currNode.prev;
        }
        size--;
        return removed;
    }

    public Object get(int index) {
        validateIndex(index);
        return getNode(index).value;
    }

    public Object set(Object value, int index) {
        validateIndex(index);
        validateValue(value);
        Object oldValue = getNode(index).value;
        getNode(index).value = value;
        return oldValue;
    }

    public void clear() {
        while (head != tail) {
            head = head.next;
            head.prev = null;
        }
        tail = head = null;
        size = 0;
    }

    public int indexOf(Object value) {
        Node currHead = head;

        for (int i = 0; i < size; i++) {
            if (value.equals(currHead.value)) {
                return i;
            }
            currHead = currHead.next;
        }

        return -1;
    }

    public int lastIndexOf(Object value) {
        Node currTail = tail;

        for (int i = size - 1; i >= 0; i--) {
            if (value.equals(currTail.value)) {
                return i;
            }
            currTail = currTail.prev;
        }
        return -1;
    }

    private Node getNode(int index) {
        Node currNode;

        if (index <= size / 2) {
            currNode = head;

            for (int i = 0; i < index; i++) {
                currNode = currNode.next;
            }

        } else {
            currNode = tail;

            for (int i = size - 1; i > index; i--) {
                currNode = currNode.prev;
            }
        }
        return currNode;
    }

    public String toString() {
        StringJoiner sj = new StringJoiner(",", "[", "]");
        Node curr = head;
        for (int i = 0; i < size ; i++) {
            sj.add((CharSequence) curr.value);
        }
        return sj.toString();
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    private static class Node {

        private Node next;
        private Node prev;
        private Object value;

        private Node(Object value) {
            this.value = value;
        }
    }

}
