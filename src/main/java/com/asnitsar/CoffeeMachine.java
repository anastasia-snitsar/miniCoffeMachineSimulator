package com.asnitsar;

import java.util.Scanner;

public class CoffeeMachine {
    public static int money = 550;
    public static int water = 400;
    public static int milk = 540;
    public static int coffee = 120;
    public static int cups = 9;
    public static String coffeeType;

    public static void buy() {
        switch (coffeeType) {
            case "1":
                if (water < 250) {
                    System.out.println("Sorry, not enough water!");
                } else if (coffee < 16) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (cups < 1) {
                    System.out.println("Sorry, not enough cups!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    money += 4;
                    water -= 250;
                    coffee -= 16;
                    cups -= 1;
                }
                break;
            case "2":
                if (water < 350) {
                    System.out.println("Sorry, not enough water!");
                } else if (coffee < 20) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (milk < 75) {
                    System.out.println("Sorry, not enough milk!");
                } else if (cups < 1) {
                    System.out.println("Sorry, not enough cups!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    money += 7;
                    water -= 350;
                    milk -= 75;
                    coffee -= 20;
                    cups -= 1;
                }
                break;
            case "3":
                if (water < 200) {
                    System.out.println("Sorry, not enough water!");
                } else if (coffee < 12) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (milk < 100) {
                    System.out.println("Sorry, not enough milk!");
                } else if (cups < 1) {
                    System.out.println("Sorry, not enough cups!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    money += 6;
                    water -= 200;
                    milk -= 100;
                    coffee -= 12;
                    cups -= 1;
                }
                break;
            case "back":
                break;
            default:
                System.out.println("This type of coffee is not available.");
        }
    }

    public static void fill(Scanner scanner) {
        System.out.println("Write how many ml of water you want to add: ");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffee += scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add: ");
        cups += scanner.nextInt();

    }

    public static void take() {
        System.out.printf("I gave you $%d\n", money);
        money = 0;
    }

    public static void coffeeMachineStatus() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffee + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.printf("$%d of money\n", money);
    }

    public static void menu() {
        Scanner scn = new Scanner(System.in);
        boolean exit = false;
        int cupsCount = 0;
        while(!exit) {
            System.out.println("Write action (buy, fill, take, clean, remaining, exit): ");
            String action = scn.next();
            switch (action) {
                case "buy":
                    if (cupsCount >= 10) {
                        System.out.println("I need cleaning!");
                    } else {
                        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back:");
                        coffeeType = scn.next();
                        buy();
                        cupsCount++;
                    }
                    break;
                case "fill":
                    fill(scn);
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    coffeeMachineStatus();
                    break;
                case "exit":
                    exit = true;
                    break;
                case "clean":
                    cupsCount =0;
                    System.out.println("I have been cleaned!");
                    break;
                default:
                    System.out.println("This action is not available.");
            }
        }
    }
}
