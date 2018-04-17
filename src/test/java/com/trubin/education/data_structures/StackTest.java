package com.trubin.education.data_structures;

import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class StackTest {

    Stack stack;
    Stack stackFiveEl;

    @Before
    public void before() {
        stackFiveEl = new Stack(3);
        stack = new Stack();

        char c = 'A';
        for (int i = 0; i < 5; i++) {
            String value = String.valueOf(c);
            stackFiveEl.push(value);
            c++;
        }
    }

    @Test
    public void push() {
        stack.push("A");
        assertEquals("A", stack.peek());
        stack.push("B");
        assertEquals("B", stack.peek());
        assertNotEquals("D", stack.peek());
        assertFalse(stack.getSize() == 3);
        assertTrue(stack.getSize() == 2);
    }

    @Test(expected = EmptyStackException.class)
    public void peek() {
        assertEquals("E", stackFiveEl.peek());
        assertTrue(stackFiveEl.getSize() == 5);
        assertEquals("A", stack.peek());
    }

    @Test(expected = EmptyStackException.class)
    public void pop() {
        assertTrue(stackFiveEl.getSize() == 5);
        assertEquals("E", stackFiveEl.pop());
        assertFalse(stackFiveEl.getSize() == 5);
        assertTrue(stackFiveEl.getSize() == 4);
        assertEquals("D", stackFiveEl.pop());
        assertEquals("C", stackFiveEl.pop());
        assertNotEquals("D", stackFiveEl.peek());
        assertEquals("B", stackFiveEl.pop());
        assertEquals("A", stackFiveEl.pop());
        assertEquals("A", stackFiveEl.pop());
        assertTrue(stackFiveEl.getSize() == 0);
    }

    @Test
    public void search() {
        assertEquals(0, stackFiveEl.search("A"));
        assertEquals(4, stackFiveEl.search("E"));
        stackFiveEl.push("S");
        assertNotEquals(0, stackFiveEl.search("S"));
        assertNotEquals(-1, stackFiveEl.search("S"));
        assertEquals(5, stackFiveEl.search("S"));
    }

    @Test
    public void empty() {
        assertTrue(stack.getSize() == 0);
        assertTrue(stack.empty());
        assertFalse(stackFiveEl.empty());
    }
}
