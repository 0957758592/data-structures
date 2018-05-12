package com.danilov.datastructures.queue;

import java.util.NoSuchElementException;

public class LinkedQueue extends AbstractQueue {

    private Node head;

    public void enqueue(Object value){
        validateValue(value);
        Node newNode = new Node(value);
        if(size == 0){
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null){
               curr = curr.next;
            }
            curr.next = newNode;
        }
        size++;
    }

    public Object dequeue(){
        if (head == null || size == 0){
            throw new NoSuchElementException("dequeue() : in LinkedQueue");
        }
        validateValue(head.value);
        Object result = head.value;
        head = head.next;
        size--;
        return result;
    }

    private static class Node {

        private Node next;
        private Object value;
        private Node(Object value) {
            this.value = value;
        }
    }

}
