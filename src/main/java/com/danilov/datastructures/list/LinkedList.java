package com.danilov.datastructures.list;

public class LinkedList extends AbstractList {

    Node head;
    Node tail;

    public void add(Object value, int index) {
        validateAddIndex(index);
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
        Node currNode;
        Object removed;

        if (index == 0) {
            currNode = head;
            removed = head.value;
            head = head.next;
        } else if (index == size - 1) {
            currNode = tail;
            removed = tail.value;
            tail = tail.prev;
        } else {
            currNode = getNode(index);
            removed = currNode.value;
            currNode.prev.next = currNode.next;
            currNode.next.prev = currNode.prev;
        }

        size--;
        return removed;
    }

    public Object get(int index) {
        validateIndex(index);
        Node currNode;

        if (index == 0) {
            return head.value;
        } else if (index == size - 1) {
            return tail.value;
        } else {
            currNode = getNode(index);
            return currNode.value;
        }
    }

    public Object set(Object value, int index) {
        validateIndex(index);
        Object oldValue;

        if (index == 0) {
            oldValue = head.value;
            head.value = value;
        } else if (index == size - 1){
            oldValue = tail.value;
            tail.value = value;
        } else {
            Node currNode = getNode(index);
            oldValue = currNode.value;
            currNode.value = value;
        }
        return oldValue;
    }

    public void clear() {
        while (head != tail) {
            head = head.next;
            head.prev = null;
        }
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    public int indexOf(Object value) {
        Node currHead = head;

        for (int i = 0; i <= size - 1; i++) {
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
        Node curr = head;
        String result = "[";

        for (int i = 0; i <= size - 1; i++) {
            if (i == size - 1) {
                result += curr.value;
            } else {
                result += curr.value + ", ";
                curr = curr.next;
            }
        }
        result += "]";

        return result;
    }

}
