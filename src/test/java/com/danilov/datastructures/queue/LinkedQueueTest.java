package com.danilov.datastructures.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedQueueTest extends AbstractQueueTest {

    public Queue getQueue() {
        return new LinkedQueue();
    }
}
