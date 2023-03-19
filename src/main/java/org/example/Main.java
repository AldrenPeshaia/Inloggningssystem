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

        }
    }
}
