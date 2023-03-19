package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        ObjectMapper objectMapper = new ObjectMapper();

        Scanner reader = new Scanner(System.in);
        while (true) {
            System.out.println("--------------------------");
            System.out.println("1. Create account");
            System.out.println("2. View account details");
            System.out.println("3. Exit");
            System.out.println("---------------------------");

            int choice = reader.nextInt();
            reader.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter your full name:");
                    String fullName = reader.nextLine();
                    System.out.println("Enter your username:");
                    String username = reader.nextLine();
                    System.out.println("Enter your password:");
                    String password = reader.nextLine();
                    userService.createUserAccount(fullName, username, password);
                    break;
                case 2:
                    int counter = 1;
                    for (Users item : userService.users){
                        System.out.println(counter+ "- "+item.getUserName());
                        counter++;
                    }
                    System.out.println("Enter your username:");
                    String viewUsername = reader.nextLine();
                    userService.viewUsersDetails(viewUsername);
                    break;
                case 3:
                    System.out.println("you closed the program!");
                    try {
                        objectMapper.writeValue(UserService.usersFile, userService.users);
                    } catch (IOException e) {
                        System.err.println("could not save your information " + e.getMessage());
                    }
                    return;
                default:
                    System.out.println("you pushed the wrong button. Try again");
            }
        }
    }
}
