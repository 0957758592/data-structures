package com.trubin.education.data_structures.stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LinkedStackTest {
    LinkedStack linkedStack;
    Object[] array;
    Object[] arrayFive;

    @Before
    public void before() {
        linkedStack = new LinkedStack();
        array = new Object[]{"A", "B", "C"};
        arrayFive = new Object[5];
        char c = 'A';

        for (int i = 0; i < 5; i++) {
            String val = String.valueOf(c);
            arrayFive[i] = val;
            c++;
        }
    }

    @Test
    public void push() {
        linkedStack.push("A");
        linkedStack.push("B");
        linkedStack.push("C");

        assertEquals("C", linkedStack.peek());
        assertEquals("C", linkedStack.pop());
        assertEquals("B", linkedStack.pop());
        assertEquals("A", linkedStack.peek());
        assertEquals("A", linkedStack.pop());
    }

    @Test(expected = NullPointerException.class)
    public void peek() {

        for (int i = linkedStack.size; i > 0; i--) {
            if (i == 0) {
                assertEquals("A", linkedStack.peek());
            }
            assertEquals(arrayFive[i], linkedStack.pop());
        }

        assertTrue(linkedStack.size == 0);
        assertEquals(0, linkedStack.peek());
    }

    @Test(expected = NullPointerException.class)
    public void pop() {

        for (int i = 0; i < linkedStack.size; i++) {
            if (i == 0) {
                assertEquals("A", linkedStack.peek());
            }
            assertEquals(arrayFive[i], linkedStack.pop());
        }

        assertEquals("A", linkedStack.pop());
        linkedStack.push("S");
        assertEquals("S", linkedStack.peek());
    }

}
