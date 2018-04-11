package com.trubin.education.lesson_1.lists;

public class ArrayList<T> implements List {

    private static final int INITIAL_CAPACITY = 10;
    private int size = 10;
    private Object[] array;

    public ArrayList(){
        this(INITIAL_CAPACITY);
    }

    private ArrayList(int capacity){
        array = new Object[capacity];
    }

    public void add(ArrayList value) {
        add(value, size);
    }

    public void indexValidate(int index){

        if (index < 0 || index > size ){
            throw new IndexOutOfBoundsException
             ("Index should be between 0 and " + size + " (inclusive), but was " + index);
        }
    }

    public void add(ArrayList value, int index) {
        indexValidate(index);
        size++;
        for (int i = size; i > index; i--) {
            array[i] = array[i-1];
            array[index] = value;
        }

        size();

        // нужна проверка на size == array.langth => увеличить массив...
        // но у меня получается тупо ...
    }

    public ArrayList remove(int index) {
        indexValidate(index);
        for (int i = index; i < size; i++) {
            array[i] = i-1;
        }
        size--;
        return new ArrayList();
    }

    public ArrayList get(int index) {
        indexValidate(index);
        for (int i = 0; i < size; i++) {
            if (index == i){
                return new ArrayList(index);
            }
        }
        return null;
    }

    public ArrayList set(ArrayList value, int index) {
        //
        return new ArrayList();
    }

    public void clear() {
        size = 0;
    }

    public int size() {
        if (size == array.length){
            size *= (int) 1.5;
        } if ( (size*1.5) < array.length ) {
            size /= (int) 1.5;
        }
        return size;
    }

    public boolean isEmpty() {
        return size != 0;
    }

    public boolean contains(ArrayList value) {
        return indexOf(value)!= -1;
    }

    public int indexOf(ArrayList value) {
        for (int i = 0; i < size; i++) {
            if(array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(ArrayList value) {
        for (int i = size; i > 0; i--) {
            if(array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
