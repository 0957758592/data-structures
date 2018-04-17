package com.trubin.education.data_structures.queue;

import com.trubin.education.data_structures.Node;

public class LinkedQueue {

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
        Object result = head.value;
        head = head.next;
        size--;
        return result;
    }

    public int getSize(){
        return size;
    }

}
