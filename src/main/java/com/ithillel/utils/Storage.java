package com.ithillel.utils;

import java.util.ArrayDeque;
import java.util.Deque;

public class Storage {

    private static Storage object;

    private Storage() {
    }

    public static Storage getStorage() {
        if (object == null) {
            return object = new Storage();
        }
        return object;
    }

    public <T> T get(Deque<T> deque) {
        return deque.pollLast();
    }

    public <T> void put(T obj, Deque<T> deque) {
        deque.add(obj);
    }

    public static void main(String[] args) {
        Storage storage = getStorage();

        Deque<String> coll1 = new ArrayDeque<>();

        storage.put("1st", coll1);
        storage.put("2st", coll1);
        storage.put("3st", coll1);
        storage.put("4th", coll1);
        storage.put("5st", coll1);

        System.out.println(storage.get(coll1));
        System.out.println(storage.get(coll1));
        System.out.println(coll1);

/*
        //работает, если добавить <T> в название класса
        Deque<Random> coll2 = new ArrayDeque<>();

        storage.put("1st", coll2);
        storage.put("2st", coll2);
        storage.put('3', coll2);
        storage.put(new Object(), coll2);
        storage.put('5', coll2);
        storage.put(new Random(), coll2);

        System.out.println(storage.get(coll2));
        System.out.println(storage.get(coll2));
*/
    }
}