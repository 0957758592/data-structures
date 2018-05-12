package com.danilov.datastructures.stack;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public abstract class AbstractStackTest {
    Stack emptyStack = getStack();
    Stack stackWithFiveElements = getStack();

    public abstract Stack getStack();

    @Before
    public void before() {
        int size = 5;

        char c = 'A';
        for (int i = 0; i < size; i++) {
            String val = String.valueOf(c);
            stackWithFiveElements.push(val);
            c++;
        }
    }

    @Test
    public void testPush() {
        emptyStack.push("A");
        emptyStack.push("B");
        emptyStack.push("C");
        stackWithFiveElements.push("F");

        assertEquals("C", emptyStack.peek());
        assertEquals("C", emptyStack.pop());
        assertEquals("B", emptyStack.pop());
        assertEquals("A", emptyStack.peek());
        assertEquals("A", emptyStack.pop());
        assertEquals("F", stackWithFiveElements.pop());
    }

    @Test
    public void testPeek() {
        emptyStack.push("A");
        assertEquals("A", emptyStack.peek());
        assertEquals("E", stackWithFiveElements.peek());
        stackWithFiveElements.pop();
        assertEquals("D", stackWithFiveElements.peek());
        stackWithFiveElements.push(1);
        stackWithFiveElements.push(2);
        assertEquals(2, stackWithFiveElements.peek());
        assertTrue(stackWithFiveElements.peek().equals(2));
        assertFalse(stackWithFiveElements.peek().equals("2"));
    }

    @Test(expected = NoSuchElementException.class)
    public void testPeekException() {
        emptyStack.peek();
    }

    @Test
    public void testPop() {
        emptyStack.push("A");
        emptyStack.push("B");
        emptyStack.push("C");

        assertEquals("E", stackWithFiveElements.pop());
        assertEquals("D", stackWithFiveElements.pop());
        assertEquals("C", stackWithFiveElements.pop());
        assertEquals("B", stackWithFiveElements.pop());
        assertEquals("A", stackWithFiveElements.pop());
        assertTrue(stackWithFiveElements.size() == 0);
        assertEquals("C", emptyStack.pop());
        assertEquals("B", emptyStack.pop());
        assertEquals("A", emptyStack.pop());
        assertTrue(emptyStack.size() == 0);

    }

    @Test(expected = NoSuchElementException.class)
    public void testPopException() {
        emptyStack.pop();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPushException() {
        emptyStack.push(null);
    }

}
