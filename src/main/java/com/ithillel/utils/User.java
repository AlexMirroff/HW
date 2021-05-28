package com.ithillel.utils;

import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.ithillel.utils.DataProvider.getRandomInt;
import static com.ithillel.utils.DataProvider.getRandomString;

@Getter
public class User {

    private static Random random = new Random();

    private String name;
    private int age;
    private String email;
    private String gender;

    public User() {
        this.name = getRandomString();
        this.age = getRandomInt();
        this.email = emailGenerator();
        this.gender = sexGenerator();
    }

    private static String emailGenerator() {
        if (random.nextBoolean()) {
            return getRandomString() + "@gmail.com";
        } else return null;
    }

    private static String sexGenerator() {
        if (random.nextBoolean()) {
            return "male";
        } else return "female";
    }

    /*

    public User() {
        this.name = "user_name_"+getRandomInt();
        this.age = getRandomInt();
        this.email = this.name+"@gmail.com";
        this.gender = sexGenerator();
    }*/

    public static void main(String[] args) {

        Map<String, List<User>> map1 =
                Stream.generate(User::new)
                        .limit(20)
                        .filter(user -> user.getAge() > 18)
                        .filter(user -> user.getEmail() != null)
                        .collect(Collectors.groupingBy(User::getGender));

        System.out.println(map1);
    }
}







