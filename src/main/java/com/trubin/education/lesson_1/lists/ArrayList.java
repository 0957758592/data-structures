package com.trubin.education.lesson_1.lists;

public class ArrayList implements List {

    private static final int INITIAL_CAPACITY = 5;
    private Object[] array;
    private int size;

    public ArrayList(int size) {
        array = new Object[size + 2];
    }

    public ArrayList() {
        this(INITIAL_CAPACITY);
    }

    public void add(Object value) {

        if (size == array.length) {
            Object[] newArray = new Object[(int) (array.length * 1.5)];

            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[size] = value;
        size++;
    }

    public void add(Object value, int index) {
        indexValidation(index);

        Object[] newArray = new Object[size + 1];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index, newArray, index + 1, size - index);

        array = newArray;
        array[index] = value;
        size++;
    }

    public Object remove(int index) {
        indexValidation(index);

        Object removed = array[index];
        Object[] newArray = new Object[size - 1];

        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, size - (index + 1));

        array = newArray;
        size--;
        return removed;
    }

    public Object get(int index) {
        indexValidation(index);
        return array[index];
    }

    public Object set(Object value, int index) {
        indexValidation(index);
        Object changed = array[index];
        array[index] = value;
        return changed;
    }

    public void clear() {
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public boolean contains(Object value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(Object value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object value) {
        for (int i = size - 1; i >= 0; i--) {//arrays begins from 0, size from 1
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    private void indexValidation(int index) {
        if (index < 0 || (index > size)) {
            System.out.println();
            throw new IndexOutOfBoundsException("No have such index as " + index);
        }
    }

    public String toString() {
        String result = "[";

        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                result += array[i];
            } else {
                result += array[i] + ", ";
            }
        }
        result += "]";
        return result;
    }

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        System.out.println("arrayList: " + arrayList);
        System.out.println("arrayList.size(): " + arrayList.size());
        System.out.println("arrayList.array.length: " + arrayList.array.length);
        /*add*/
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        System.out.println("arrayList.add('A', 'B', 'C') : " + arrayList);
        System.out.println("arrayList.get(1) = " + arrayList.get(1));
        /*set*/
        //arrayList.set("F", 1);
        System.out.println("arrayList.set('F',1) : " + arrayList.set("F", 1));
        System.out.println("arrayList.set('F',1) : " + arrayList);
        /*remove*/
        //  arrayList.remove(1);
        System.out.println("arrayList.remove(1) : " + arrayList.remove(1));
        System.out.println("arrayList.remove(1) : " + arrayList);
        System.out.println("arrayList.contains('C') : " + arrayList.contains("C"));
        /*addByIndex*/
        arrayList.add("B", 1);
        System.out.println("arrayList.add('B',1) : " + arrayList);
        System.out.println("arrayList.indexOf(A) : " + arrayList.indexOf("A"));
        arrayList.add("A");
        System.out.println("arrayList.add('A') : " + arrayList);
        System.out.println("arrayList.toString() : " + arrayList.toString());
        System.out.println("arrayList.lastIndexOf('A'): " + arrayList.lastIndexOf("A"));
        System.out.println("arrayList.indexOf('A') : " + arrayList.indexOf("A"));
        arrayList.clear();
        System.out.println("arrayList.clear() : " + arrayList);
        System.out.println("arrayList.isEmpty() : " + arrayList.isEmpty());
    }
}