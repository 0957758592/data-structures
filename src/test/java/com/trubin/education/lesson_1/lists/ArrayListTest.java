package com.trubin.education.lesson_1.lists;

import org.junit.Test;

public class ArrayListTest implements List {


    @Test //add to the end
    public void add(ArrayList value) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(value,2);
    }

    public void add(ArrayList value, int index) {

    }

    public void add(Object value) {

    }

    public void add(Object value, int index) {

    }

    public ArrayList remove(int index) {
        return null;
    }

    public ArrayList get(int index) {
        return null;
    }

    public Object set(Object value, int index) {
        return null;
    }

    public ArrayList set(ArrayList value, int index) {
        return null;
    }

    public void clear() {

    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean contains(Object value) {
        return false;
    }

    public int indexOf(Object value) {
        return 0;
    }

    public int lastIndexOf(Object value) {
        return 0;
    }

    public boolean contains(ArrayList value) {
        return false;
    }

    public int indexOf(ArrayList value) {
        return 0;
    }

    public int lastIndexOf(ArrayList value) {
        return 0;
    }
}
