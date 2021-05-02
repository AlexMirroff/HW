package com.ithillel.utils;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    public static void main(String[] args) {

        Random random = new Random();
        int r = random.nextInt(10) + 1;
        Scanner scanner = new Scanner(System.in);
        int input;

        System.out.print("Guess integer from 0 to 10: ");

        for (; ; ) {
            try {
                input = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("You inputed invalid value");
                break;
            }
            if (input == r) {
                System.out.print("You Guess!");
                break;
            } else {
                System.out.print("Missed. Please take another try: ");
            }
        }
    }
}