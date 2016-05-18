package com.theironyard;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws Exception {
        boolean cont = true;

            System.out.println("Welcome!");

            System.out.println("What is your name?");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                throw new Exception("Invalid name input!");
            } else {
                System.out.println("Welcome, " + name);
            }

        while(cont) {

            System.out.println("ATM Menu:");
            System.out.println("1 = Check Balance");
            System.out.println("2 = Withdraw");
            System.out.println("3 = Cancel");
            String menu = scanner.nextLine();

            int menuNum = Integer.valueOf(menu);
            if (menuNum == 1) {
                System.out.println("Your balance is $100");
            }
            else if (menuNum == 2) {
                System.out.println("Withdraw");
                System.out.println("Type amount you would like to withdraw...");
                String num = scanner.nextLine();
                int withInt = Integer.valueOf(num);
                if (withInt > 100) {
                    throw new Exception("Insufficient funds in you account");
                } else if (withInt <= 100) {
                    System.out.println("Please take your cash");
                }
            }

            else if (menuNum == 3) {
                System.out.println("Thank you and please come again");
                System.out.println("Are you sure you want to leave");

                break;
            }

            System.out.println("Would you like to make another transaction? [y/n]");
            String yesOrNo = scanner.nextLine();
            if (yesOrNo.equalsIgnoreCase("y")) {
                System.out.println("Back to main menu");;
            }
            else {
                System.out.println("\nThank you for banking with us!\n");
                break;
            }

        }

    }

}
