package com.trubin.education.lesson_1.lists;

public class ArrayList implements List {

    private Object[] array;
    private int size;

    public ArrayList() {
        array = new Object[size+2];
    }

    public void add(Object value) {

        if (size == array.length){
            Object[] newArray = new Object[(int)(array.length * 1.5)];

            for (int i = 0; i < size ; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[size] = value;
        size++;
    }

    public void add(Object value, int index) {
        indexValidation(index);
        array[index] = value;
    }

    public Object remove(int index) {
        indexValidation(index);
        for (int i = index; i < size-1 ; i++) {
            array[i] = array[i+1];
        }
        size--;
        return array[index];
    }

    public Object get(int index) {
        indexValidation(index);
        return array[index];
    }

    public Object set(Object value, int index) {
        indexValidation(index);
        array[index] = value;
        return value;
    }

    public void clear() {
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if(size == 0){
            return true;
        }
        return false;
    }

    public boolean contains(Object value) {
        for (int i = 0; i < size; i++) {
            if (array[i]==value){
                return true;
            }
        }
        return false;
    }

    public int indexOf(Object value){
        for (int i = 0; i <size ; i++) {
            if(array[i]==value){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object value) {
        for (int i = size-1; i > 0 ; i--) {//arrays begins from 0, size from 1
            if(array[i]==value){
                return i;
            }
        }
        return -1;
    }

    private void indexValidation(int index) {
        if(index < 0 || (index > size)){
            System.out.println();
            throw new IndexOutOfBoundsException("No have such index as " + index);
        }
    }

    public String toString(){
        String result = "[";

        for (int i = 0; i < size; i++) {
            if(i==size-1){
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
        System.out.println("arrayList size: " + arrayList.size());
        System.out.println("arrayList length: " + arrayList.array.length);
        /*add*/
        arrayList.add("B");
        arrayList.add("B");
        arrayList.add("C");
        System.out.println(arrayList);
        System.out.println("getValue index 1 = " + arrayList.get(1));
        /*set*/
        arrayList.set("F", 1);
        System.out.println("after set:" + arrayList);
        /*remove*/
        arrayList.remove(1);
        System.out.println(arrayList);
        System.out.println("contains: " + arrayList.contains("C"));
        /*addByIndex*/
        arrayList.add("B",1);
        System.out.println(arrayList);
        System.out.println("indexOf A : " + arrayList.indexOf("A"));
        arrayList.add("A");
        System.out.println(arrayList);
        System.out.println("toString: " + arrayList.toString());
        System.out.println("lastIndexOf A: " + arrayList.lastIndexOf("A"));
        System.out.println("indexOf A : " + arrayList.indexOf("A"));
        arrayList.clear();
        System.out.println(arrayList);
        System.out.println("is empty: " + arrayList.isEmpty());
    }
}