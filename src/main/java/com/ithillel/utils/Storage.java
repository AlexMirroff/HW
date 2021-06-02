package com.ithillel.utils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

public class Storage<T> {

    private static Storage storage;
    private Deque<T> deque = new ArrayDeque<>();

    private Storage() {
    }

    public static Storage getStorage() {
        if (storage == null) {
            return storage = new Storage();
        }
        return storage;
    }

    public T get() {
        return deque.pollLast();
    }

    public void put(T object) {
        deque.add(object);
    }

    public static void main(String[] args) {
        Storage storage = getStorage();


        storage.put("1st");
        storage.put(new Random());
        storage.put("3st");
        storage.put(new Object());
        storage.put("5st");

        System.out.println(storage.get());
        System.out.println(storage.get());
        System.out.println(storage.deque);  // то что осталось в сторадже

    }
}