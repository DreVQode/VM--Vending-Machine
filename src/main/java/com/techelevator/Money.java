package com.techelevator;

import java.util.Scanner;

public class Money {

    private int balance;

    Scanner keyboard = new Scanner(System.in);


    public int getBalance() {
        return balance;
    }

    public int feedMoney() {
        System.out.println("How much money would you like to deposit? 1, 5 or 10 ");
        String choice = keyboard.nextLine();
            int feedBalance = 0;
            if (choice.equals("1")) {
                feedBalance += 1;
            } else if (choice.equals("5")) {
                feedBalance += 5;
            } else if (choice.equals("10")) {
                feedBalance += 10;
            } else {
                System.out.println("Money input invalid");
            }
            return feedBalance;
//        System.out.println("Your current balance is $" + feedBalance);
        }
    }


