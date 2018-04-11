package com.trubin.education.lesson_1.lists;

// com.trubin.education.lesson_1.Listists.List, Set, Map
    public interface List {
        // add value to the end of the lists
        void add(ArrayList value);

        // we can add value by index between [0, size]
        // otherwise throw new IndexOutOfBoundsException
        void add(ArrayList value, int index);

        // we can remove value by index between [0, size - 1]
        // otherwise throw new IndexOutOfBoundsException

        // [A, B, C] remove = 0
        // [B (index = 0) , C (index = 1)]
        ArrayList remove(int index);

        // [A, B, C] size = 3
        // we can get value by index between [0, size - 1]
        // otherwise throw new IndexOutOfBoundsException
        ArrayList get(int index);

        // we can set value by index between [0, size - 1]
        // otherwise throw new IndexOutOfBoundsException
        ArrayList set(ArrayList value, int index);

        void clear();

        int size();

        boolean isEmpty();

        boolean contains(ArrayList value);

        int indexOf(ArrayList value);

        int lastIndexOf(ArrayList value);

        // [A, B, C]
        String toString();
    }

