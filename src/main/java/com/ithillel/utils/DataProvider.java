package com.ithillel.utils;

import java.util.Random;

public class DataProvider {


    public static String getRandomString() {
        Random random = new Random();
        int i;
        String res = "";
        for (int j = 0; j < random.nextInt(10) + 5; j++) { //рандомная длина строки от 5 до 15 символов
            i = random.nextInt(93) + 33;                 //раздомные символы в строке от char 33 до 126
            char ch = (char) i;
            res = res + ch;
        }
        return res;
    }

    public static int getRandomInt() {
        Random random = new Random();
        return random.nextInt(100);
    }

}
