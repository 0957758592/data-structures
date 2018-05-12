package com.danilov.datastructures.queue;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class AbstractQueueTest {
    public abstract Queue getQueue();
    Queue emptyQueue = getQueue();

    @Test
    public void testQueueAndDequeue() {

        emptyQueue.enqueue("A");
        emptyQueue.enqueue("B");
        emptyQueue.enqueue("C");
        assertEquals(3, emptyQueue.getSize());
        assertEquals("A", emptyQueue.dequeue());
        assertEquals("B", emptyQueue.dequeue());
        assertEquals("C", emptyQueue.dequeue());
        assertEquals(0, emptyQueue.getSize());

    }

    @Test(expected = NoSuchElementException.class)
    public void testQueueAndDequeueException() {
        assertEquals("D", emptyQueue.dequeue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEnqueueException() {
        emptyQueue.enqueue(null);
    }

}
