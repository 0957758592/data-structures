package com.trubin.education.lesson_1.lists;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListTest {

    private ArrayList arrayList;
    private ArrayList arrayFiveList;

    @Before
    public void before() {
        arrayList = new ArrayList();
        arrayFiveList = new ArrayList(3);
        char c = 'A';

        for (int i = 0; i < 5; i++) {
            String value = String.valueOf(c);
            arrayFiveList.add(value);
            c++;
        }
    }

    @Test()
    public void add() {
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        assertEquals("A", arrayList.get(0));
        assertEquals("B", arrayList.get(1));
        assertEquals("C", arrayList.get(2));
        assertEquals(3, arrayList.size());
        assertEquals(0, arrayList.indexOf("A"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addByIndex() {
        arrayList.add("A", 0);
        arrayList.add("B", 1);
        arrayList.add("C", 3);

        assertEquals("A", arrayList.get(0));
        assertEquals("B", arrayList.get(2));
        assertEquals(2, arrayList.size());

    }

    @Test
    public void remove() {

        arrayList.add("A", 0);
        arrayList.add("B", 1);
        arrayList.add("C");
        arrayList.add("D", 3);

        assertEquals(4, arrayList.size());
        assertEquals("A", arrayList.get(0));
        assertTrue("B", arrayList.contains("B"));
        assertEquals("C", arrayList.remove(2)); // <- remove is there
        assertFalse("C", arrayList.contains("C"));
        assertEquals(2, arrayList.indexOf("D"));
        assertEquals(3, arrayList.size());
    }

    @Test
    public void get() {
        assertEquals(5, arrayFiveList.size());
        assertEquals("E", arrayFiveList.get(4));
        assertEquals("D", arrayFiveList.get(3));
        assertEquals("C", arrayFiveList.remove(2));
        assertTrue("D", arrayFiveList.contains(arrayFiveList.get(2)));
        assertEquals("B", arrayFiveList.get(1));
        assertTrue("A", arrayFiveList.contains(arrayFiveList.get(0)));
        assertEquals(0, arrayFiveList.indexOf("A"));
        assertTrue(arrayFiveList.size() == 4);
    }

    @Test
    public void set() {
        arrayFiveList.set("A", 4);
        assertEquals("A", arrayFiveList.get(4));
        assertEquals(4, arrayFiveList.lastIndexOf("A"));
    }

    @Test
    public void clear() {
        assertEquals(5, arrayFiveList.size());
        arrayFiveList.clear();
        assertEquals(0, arrayFiveList.size());
        assertNotNull(arrayList);
        assertNotNull(arrayFiveList);
    }

    @Test
    public void size() {
        assertEquals(5, arrayFiveList.size());
        assertEquals(0, arrayList.size());
        arrayList.add("A");
        assertEquals(1, arrayList.size());
    }

    @Test
    public void isEmpty() {
        assertTrue(arrayList.isEmpty());
        arrayList.add("C");
        assertFalse(arrayList.isEmpty());
        assertFalse(arrayFiveList.isEmpty());
        arrayFiveList.clear();
        assertTrue(arrayFiveList.isEmpty());
    }

    @Test
    public void contains() {
        assertTrue("A", arrayFiveList.contains("A"));
        assertTrue("B", arrayFiveList.contains("B"));
        assertFalse("S", arrayFiveList.contains("S"));
        assertTrue("C", arrayFiveList.contains("C"));
        assertTrue("D", arrayFiveList.contains("D"));
        assertTrue("E", arrayFiveList.contains("E"));
        assertFalse("X", arrayFiveList.contains("X"));
    }

    @Test
    public void indexOf() {
        assertEquals(0, arrayFiveList.indexOf("A"));
        assertNotEquals(1, arrayFiveList.indexOf("A"));
        assertEquals(1, arrayFiveList.indexOf("B"));
        assertEquals(2, arrayFiveList.indexOf("C"));
        assertEquals(3, arrayFiveList.indexOf("D"));
        assertNotEquals(4, arrayFiveList.indexOf("D"));
        assertEquals(4, arrayFiveList.indexOf("E"));
    }

    @Test
    public void lastIndexOf() {
        assertEquals(4, arrayFiveList.lastIndexOf("E"));
        assertEquals(3, arrayFiveList.lastIndexOf("D"));
        assertEquals(1, arrayFiveList.lastIndexOf("B"));
        assertEquals(0, arrayFiveList.lastIndexOf("A"));
        arrayFiveList.set("A", 3);
        assertEquals(3, arrayFiveList.lastIndexOf("A"));
        assertNotEquals(1, arrayFiveList.lastIndexOf("A"));
    }
}
