package com.ithillel.utils;

import java.io.*;

public class UserData implements Serializable {

    public String name;
    public String email;
    public int accountId;
    public String nickname;
    public int age;
    public String address;

    public UserData(String name, String email, int accountId, String nickname, int age, String address) {
        this.name = name;
        this.email = email;
        this.accountId = accountId;
        this.nickname = nickname;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getNickname() {
        return nickname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public static void serialize(String filePath) {

        File file = new File(filePath);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            if (!file.exists()) {
                file.createNewFile();
            }

            UserData userData1 = new UserData("Nastya", "nastya@gmail.com", 1118, "kurban", 27, "Koroleva, 12H");
            //UserData userData2 = new UserData("Lёsha", null, 1119, null, 28, "Lobanovskogo, 16");

            oos.writeObject(userData1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deserialize(String filePath) {

        File file = new File(filePath);

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            UserData userData = (UserData) obj;
            System.out.println(String.format("Name: %s\nEmail: %s\nNick: %s\nAge: %d\nAccountId: %d\nAddress: %s",
                    userData.getName(), userData.getEmail(), userData.getNickname(),
                    userData.getAge(), userData.getAccountId(), userData.getAddress()));

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String filePath = "userData.txt";
        serialize(filePath);
        deserialize(filePath);
    }
}



