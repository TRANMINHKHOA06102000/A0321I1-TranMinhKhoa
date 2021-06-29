package case_study.controllers;

import java.util.Scanner;

public class FuramaController {
    static Scanner input = new Scanner(System.in);
    public static void displayMainMenu() {
        System.out.println("---------- MAIN MENU ----------");
        System.out.println("1. Employee Management");
        System.out.println("2. Customer Management");
        System.out.println("3. Facility Management ");
        System.out.println("4. Booking Managerment");
        System.out.println("5. Promotion Management");
        System.out.println("6. Exit");
        System.out.println("------------------------------");
        System.out.print("Your choose: ");
        String choose =input.nextLine();

        switch (choose) {
            case "1": {
                employee();
                break;
            }
            case "2": {
                customer();
                break;
            }
            case "3": {
                facility();
                break;
            }
            case "4": {
                booking();
                break;
            }
            case "5": {
                promotion();
                break;
            }
            case "6": {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Fail! Please choose again! Enter to continue.");
                System.out.print("Your choose: ");
                input.nextLine();
                displayMainMenu();
            }
        }
    }
    public static void employee(){
        System.out.println("---------- Employee Management ----------");
        System.out.println("1. Display list employees");
        System.out.println("2. Add new employee");
        System.out.println("3. Edit employee ");
        System.out.println("4. Return main menu");
        System.out.println("5. Exit");
        System.out.println("------------------------------");
        /*System.out.print("Your choose: ");
        String choose = input.nextLine();

        switch (choose) {
            case "1": {

                break;
            }
            case "2": {

                break;
            }
            case "3": {

                break;
            }
            case "4": {

                break;
            }
            case "5": {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Fail! Please choose again! Enter to continue.");
                System.out.print("Your choose: ");
                input.nextLine();
                employee();
            }
        }*/
    }
    public static void customer(){
        System.out.println("---------- Customer Management ----------");
        System.out.println("1. Display list customers");
        System.out.println("2. Add new customer");
        System.out.println("3. Edit customer ");
        System.out.println("4. Return main menu");
        System.out.println("5. Exit");
        System.out.println("------------------------------");
        /*System.out.print("Your choose: ");
        String choose = input.nextLine();

        switch (choose) {
            case "1": {

                break;
            }
            case "2": {

                break;
            }
            case "3": {

                break;
            }
            case "4": {

                break;
            }
            case "5": {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Fail! Please choose again! Enter to continue.");
                System.out.print("Your choose: ");
                input.nextLine();
                customer();
            }
        }*/
    }
    public static void facility(){
        System.out.println("---------- Facility Management ----------");
        System.out.println("1. Display list facility");
        System.out.println("2. Add new facility");
        System.out.println("3. Display list facility maintenance ");
        System.out.println("4. Return main menu");
        System.out.println("5. Exit");
        System.out.println("------------------------------");
        /*System.out.print("Your choose: ");
        String choose = input.nextLine();

        switch (choose) {
            case "1": {

                break;
            }
            case "2": {

                break;
            }
            case "3": {

                break;
            }
            case "4": {

                break;
            }
            case "5": {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Fail! Please choose again! Enter to continue.");
                System.out.print("Your choose: ");
                input.nextLine();
                facility();
            }
        }*/
    }
    public static void booking(){
        System.out.println("---------- Booking Management ----------");
        System.out.println("1. Add new booking");
        System.out.println("2. Display list booking");
        System.out.println("3. Create new constracts ");
        System.out.println("4. Display list contracts");
        System.out.println("5. Edit contracts");
        System.out.println("6. Return main menu");
        System.out.println("------------------------------");
        /*System.out.print("Your choose: ");
        String choose = input.nextLine();

        switch (choose) {
            case "1": {

                break;
            }
            case "2": {

                break;
            }
            case "3": {

                break;
            }
            case "4": {

                break;
            }
            case "5": {

                break;
            }
            case "6": {

                break;
            }
            case "7": {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Fail! Please choose again! Enter to continue.");
                System.out.print("Your choose: ");
                input.nextLine();
                booking();
            }
        }*/
    }
    public static void promotion(){
        System.out.println("---------- Promotion Management ----------");
        System.out.println("1. Display list customers use service");
        System.out.println("2. Display list customers get voucher");
        System.out.println("3. Return main menu");
        System.out.println("4. Exit");
        System.out.println("------------------------------");
        /*System.out.print("Your choose: ");
        String choose = input.nextLine();

        switch (choose) {
            case "1": {

                break;
            }
            case "2": {

                break;
            }
            case "3": {

                break;
            }
            case "4": {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Fail! Please choose again! Enter to continue.");
                System.out.print("Your choose: ");
                input.nextLine();
                promotion();
            }
        }*/
    }
}
