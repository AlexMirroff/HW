package com.ithillel.utils;

public class SingleInstanceProvider {

    private static SingleInstanceProvider instance;

    SingleInstanceProvider() {
    }

    public static SingleInstanceProvider getInstance() {
        if (instance == null) {
            return instance = new SingleInstanceProvider();
        }
        return instance;
    }
}