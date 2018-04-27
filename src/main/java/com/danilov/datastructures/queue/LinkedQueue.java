package com.danilov.datastructures.queue;

import java.util.NoSuchElementException;

public class LinkedQueue implements Queue {

    Node head;
    int size;

    public void enqueue(Object value){
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
            throw new NoSuchElementException("dequeue() in LinkedQueue");
        }
        Object result = head.value;
        head = head.next;
        size--;
        return result;
    }

    public int getSize(){
        return size;
    }

}
