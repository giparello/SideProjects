package com.BetterFriend.client.services;

import com.BetterFriend.client.model.UserCredentials;

import java.util.Scanner;

public class ConsoleService {
    private final Scanner scanner = new Scanner(System.in);

    public void printGreeting(){
        System.out.println("Welcome to the Be a Better Friend application!");

    }
    public int promptForMenuSelection(String prompt) {
        int menuSelection;
        System.out.print(prompt);
        try {
            menuSelection = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }
    public UserCredentials promptForCredentials() {
        String username = promptForString("Username: ");
        String password = promptForString("Password: ");
        return new UserCredentials(username, password);
    }
    public String promptForString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }


    public void printMenu(){
        System.out.println();
        System.out.println("1: Add a new friend");
        System.out.println("2: See a list of all friends");
        System.out.println("3: Update a friend");
        System.out.println("4: Get a random friend");
        System.out.println("5: Get a friend's information");
        System.out.println("0: Exit ");
    }
    public void pause() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }



}
