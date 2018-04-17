package com.trubin.education.data_structures.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedQueueTest {

    LinkedQueue linkedQueue;
    Object[] array;

    @Before
    public void before() {
        linkedQueue = new LinkedQueue();
        array = new Object[]{"A", "B", "C"};
    }

    @Test(expected = NullPointerException.class)
    public void testDequeueAndDequeue() {

        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");
        linkedQueue.enqueue("C");

        assertEquals(3, linkedQueue.getSize());

        for (Object obj : array) {
            assertEquals(obj, linkedQueue.dequeue());

        }
        assertEquals(0, linkedQueue.getSize());
        assertEquals("D", linkedQueue.dequeue());
        linkedQueue.enqueue("D");
        assertEquals("D", linkedQueue.dequeue());
    }

}
