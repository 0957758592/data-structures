package com.danilov.datastructures.list;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public abstract class AbstractListTest {

    List emptyList = getList();
    List listWithFiveElements = getList();

    public abstract List getList();

    @Before
    public void before() {
        int newSize = 5;

        char c = 'A';
        for (int i = 0; i < newSize; i++) {
            String val = String.valueOf(c);
            listWithFiveElements.add(val);
            c++;
        }
    }

    @Test
    public void testAdd() {
        emptyList.add("A");
        emptyList.add("B");
        emptyList.add("C");
        emptyList.add("D");

        assertEquals("A", emptyList.get(0));
        assertEquals("B", emptyList.get(1));
        assertEquals("C", emptyList.get(2));
        assertEquals("D", emptyList.get(3));
    }

    @Test
    public void testAddByIndex() {
        emptyList.add("A");
        emptyList.add("B");
        emptyList.add("D");
        emptyList.add("E");
        emptyList.add("G");
        assertEquals("D", emptyList.get(2));
        assertEquals("G", emptyList.get(4));
        emptyList.add("C", 2);
        emptyList.add("F", 5);
        emptyList.add("AA", 0);
        emptyList.add("GG", 8);
        assertEquals("C", emptyList.get(3));
        assertEquals("F", emptyList.get(6));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddByIndexException() {
        emptyList.add(0, 1);
    }

    @Test
    public void testRemove() {
        assertEquals(5, listWithFiveElements.size());
        assertEquals("E", listWithFiveElements.get(4));
        assertEquals("E", listWithFiveElements.remove(4));
        assertEquals("D", listWithFiveElements.get(3));
        assertEquals("A", listWithFiveElements.remove(0));
        assertEquals("C", listWithFiveElements.remove(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveException() {
        emptyList.remove(0);
    }

    @Test
    public void testGet() {

        for (int i = 0; i <= listWithFiveElements.size() - 1; i++) {
            Object[] objects = new Object[listWithFiveElements.size()];
            objects[i] = listWithFiveElements.get(i);
            assertEquals(objects[i], listWithFiveElements.get(i));
        }
        assertEquals("A", listWithFiveElements.get(0));
        assertEquals("B", listWithFiveElements.get(1));
        assertEquals("C", listWithFiveElements.get(2));
        assertEquals("D", listWithFiveElements.get(3));
        assertEquals("E", listWithFiveElements.get(4));
        assertEquals("E", listWithFiveElements.set("A", 4));
        assertEquals("A", listWithFiveElements.get(4));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetException() {
        listWithFiveElements.get(5);
    }

    @Test
    public void testSet() {
        listWithFiveElements.set(1, 4);
        listWithFiveElements.set("2", 3);
        listWithFiveElements.set(3, 2);
        listWithFiveElements.set("4", 1);
        listWithFiveElements.set("E", 0);

        assertEquals("E", listWithFiveElements.get(0));
        assertFalse(listWithFiveElements.contains("S"));
        assertNotEquals("E", listWithFiveElements.get(4));
    }

    @Test
    public void testClear() {
        assertEquals(5, listWithFiveElements.size());
        listWithFiveElements.clear();
        assertEquals(0, listWithFiveElements.size());
        assertTrue(listWithFiveElements.size() == 0);
    }

    @Test
    public void testSize() {
        assertTrue(listWithFiveElements.size() == 5);
        listWithFiveElements.clear();
        assertTrue(listWithFiveElements.size() == 0);
        assertTrue(emptyList.size() == 0);
        assertEquals(0, emptyList.size());
        emptyList.add(1);
        assertEquals(1, emptyList.size());
    }

    @Test
    public void testIsEmpty() {
        assertEquals(0, emptyList.size());
        assertTrue(emptyList.isEmpty());
        assertFalse(listWithFiveElements.isEmpty());
        listWithFiveElements.clear();
        assertTrue(listWithFiveElements.isEmpty());
    }

    @Test
    public void testContains() {
        assertTrue(listWithFiveElements.contains("A"));
        assertTrue(listWithFiveElements.contains("B"));
        assertTrue(listWithFiveElements.contains("C"));
        assertTrue(listWithFiveElements.contains("D"));
        assertTrue(listWithFiveElements.contains("E"));
        assertFalse(listWithFiveElements.contains("F"));
        listWithFiveElements.add("F");
        assertTrue(listWithFiveElements.contains("F"));
    }

    @Test
    public void testIndexOf() {
        assertEquals(0, listWithFiveElements.indexOf("A"));
        assertEquals(1, listWithFiveElements.indexOf("B"));
        assertEquals(2, listWithFiveElements.indexOf("C"));
        assertEquals(3, listWithFiveElements.indexOf("D"));
        assertEquals(4, listWithFiveElements.indexOf("E"));
        listWithFiveElements.set("E", 0);
        listWithFiveElements.set("A", 3);
        assertEquals("E", listWithFiveElements.get(0));
        assertEquals("A", listWithFiveElements.get(3));
        assertEquals(0, listWithFiveElements.indexOf("E"));
        assertEquals(3, listWithFiveElements.indexOf("A"));
        listWithFiveElements.add("E", 4);
        assertEquals(5, listWithFiveElements.lastIndexOf("E"));
        assertEquals(1, listWithFiveElements.indexOf("B"));
        assertEquals(1, listWithFiveElements.lastIndexOf("B"));
    }

    @Test
    public void testLastIndexOf() {
        assertEquals(0, listWithFiveElements.lastIndexOf("A"));
        listWithFiveElements.set("A", 1);
        assertEquals(1, listWithFiveElements.lastIndexOf("A"));
        assertEquals(4, listWithFiveElements.lastIndexOf("E"));
        listWithFiveElements.add("E");
        assertEquals(5, listWithFiveElements.lastIndexOf("E"));
    }
}
