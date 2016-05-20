package com.theironyard;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static HashMap<String, Double> people = new HashMap<>();

    public static void main(String[] args) throws Exception {
        boolean cont = true;

        System.out.println("Welcome!");

        while(cont) {

            System.out.println("What is your name?");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                throw new Exception("Invalid name input!");
            }
            else {
                System.out.println("Welcome, " + name);
            }

            if (people.get(name) == null) {
                System.out.println("That name was not recognized, would you like to set up an account!");
                System.out.println("1 = Yes");
                System.out.println("2 = No");
                String choice = scanner.nextLine();

                int choiceMenu = Integer.valueOf(choice);
                if (choiceMenu == 1) {
                    System.out.println("Setting up your new account...");

                    if (name.isEmpty()) {
                        throw new Exception("Invalid name input!");
                    }
                    people.put(name, 100.0);
                    System.out.println("Welcome to your new account, " + name);
                    Double balance = people.get(name);
                    System.out.println("Your balance is $" + balance);
                }
                else if (choiceMenu == 2) {
                    System.out.println("Thank you and please come again");
                    continue;
                }
            }
            while (true) {
                System.out.println("ATM Menu:");
                System.out.println("1 = Check Balance");
                System.out.println("2 = Withdraw");
                System.out.println("3 = Cancel");
                System.out.println("4 = Remove Account");
                System.out.println("5 = Deposit Funds");

                String menu = scanner.nextLine();

                int menuNum = Integer.valueOf(menu);
                if (menuNum == 1) {
                    System.out.println("Your balance is " + people.get(name));
                }
                else if (menuNum == 2) {
                    System.out.println("Withdraw");
                    System.out.println("Type amount you would like to withdraw...");
                    String num = scanner.nextLine();
                    int withInt = Integer.valueOf(num);
                    if (withInt > people.get(name)) {
                        throw new Exception("Insufficient funds in you account");
                    }
                    else if (withInt <= people.get(name)) {
                        System.out.println("Please take your cash");
                        double oldBalance = people.get(name);
                        people.put(name, oldBalance - withInt);
                    }
                }
                else if (menuNum == 3) {
                    System.out.println("Thank you and please come again");
                    break;
                }
                else if (menuNum == 4){
                    people.remove(name);
                    System.out.println("Your account has been removed from our system");
                    break;
                }

                else if (menuNum == 5) {
                    System.out.println("Deposit");
                    System.out.println("Type amount you would like to deposit...(Cash Only)");
                    String num = scanner.nextLine();
                    int oldBalance = Integer.valueOf(num);
                    if (oldBalance <= 0) {
                        throw new Exception("No funds to deposit into your account");
                    }
                    else if (oldBalance >= people.get(name)) {
                        System.out.println("Cash has been deposited to your account");
                        double newBalance = people.get(name);
                        people.put(name, newBalance + oldBalance);
                    }
                }

                System.out.println("Would you like to make another transaction? [y/n]");
                String yesOrNo = scanner.nextLine();
                if (yesOrNo.equalsIgnoreCase("y")) {
                    System.out.println("Back to main menu");
                    ;
                } else {
                    System.out.println("\nThank you for banking with us!\n");
                    break;
                }
            }
        }
    }
}