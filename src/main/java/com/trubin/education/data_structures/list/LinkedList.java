package com.trubin.education.data_structures.list;

import com.trubin.education.List;
import com.trubin.education.data_structures.Node;

public class LinkedList implements List {

    Node head;
    Node tail;
    int size;

    public void add(Object value) {
        Node newNode = new Node(value);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {

            if (size == 1) {
                head.next = newNode;
                newNode.prev = head;
                tail = newNode;

            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }
        size++;
    }

    public void add(Object value, int index) {
        indexValidation(index);
        Node newNode = new Node(value);

        if (index <= indexDirection()) {
            Node currHead = head;

            if (index == 0) {
                newNode.next = currHead;
                currHead.prev = newNode;
                head = newNode;

            } else {
                for (int i = 0; i < index; i++) {
                    currHead = currHead.next;
                }
                currHead.prev.next = newNode;
                newNode.next = currHead;
                newNode.prev = currHead.prev;
                currHead.prev = newNode;
            }

        } else {
            Node currTail = tail;

            if (index == size - 1) {
                currTail.next = newNode;
                newNode.prev = currTail;
                tail = newNode;

            } else {

                for (int i = size - 1; i > index; i--) {
                    currTail = currTail.prev;
                }
                newNode.prev = currTail;
                newNode.next = currTail.next;
                currTail.next.prev = newNode;
                currTail.next = newNode;
            }
        }
        size++;
    }

    public Object remove(int index) {
        indexValidation(index);
        Object removed;

        if (index <= indexDirection()) {

            if (index == 0) {
                removed = head.value;
                head = head.next;

            } else {
                Node currHead = head;

                for (int i = 0; i < index; i++) {
                    currHead = currHead.next;
                }
                removed = currHead.value;
                currHead.prev.next = currHead.next;
                currHead.next.prev = currHead.prev;
            }

        } else {

            if (index == size - 1) {
                removed = tail.value;
                tail = tail.prev;

            } else {
                Node currTail = tail;

                for (int i = size; i > index; i--) {
                    currTail = currTail.prev;
                }
                removed = currTail.value;
                currTail.prev.next = currTail.next;
                currTail.next.prev = currTail.prev;
            }
        }
        size--;
        return removed;
    }

    public Object get(int index) {
        indexValidation(index);

        if (index <= indexDirection()) {

            if (index == 0) {
                return head.value;
            } else {
                Node currHead = head;

                for (int i = 0; i < index; i++) {
                    currHead = currHead.next;
                }
                return currHead.value;
            }

        } else {

            if (index == size - 1) {
                return tail.value;

            } else {
                Node currTail = tail;

                for (int i = size - 1; i > index; i--) {
                    currTail = currTail.prev;
                }
                return currTail.value;
            }
        }
    }

    public Object set(Object value, int index) {
        indexValidation(index);
        Object oldValue;

        if (index <= indexDirection()) {

            if (index == 0) {
                oldValue = head.value;
                head.value = value;

            } else {
                Node currHead = head;

                for (int i = 0; i < index; i++) {
                    currHead = currHead.next;
                }
                oldValue = currHead.value;
                currHead.value = value;
            }

        } else {

            if (index == size - 1) {
                oldValue = tail.value;
                tail.value = value;

            } else {
                Node currTail = tail;

                for (int i = size - 1; i > index; i--) {
                    currTail = currTail.prev;
                }
                oldValue = currTail.value;
                currTail.value = value;
            }
        }
        return oldValue;
    }

    public void clear() {
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
        Node currTail = tail;
        Node currHead = head;
        int i = 0;
        int j = size - 1;

        while (i <= j) {

            if (value.equals(currHead.value) || value.equals(currTail.value)) {
                return true;
            }
            currTail = currTail.prev;
            currHead = currHead.next;
            i++;
            j--;
        }
        return false;
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


    private void indexValidation(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("There are no any indexes here as " + index);
        }
    }


    private int indexDirection() {
        int direction = Math.round(size / 2);
        return direction;
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
