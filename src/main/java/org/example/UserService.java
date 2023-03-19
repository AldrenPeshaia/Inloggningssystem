package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {

    public List<Users> users;
    public static final File usersFile = new File("src/main/resources/Users.json");
    public static final ObjectMapper objectMapper = new ObjectMapper();


    public UserService() {

        try {
            if (usersFile.exists()) {
                users = objectMapper.readValue(usersFile, new TypeReference<>() {
                });
            } else {
                users = new ArrayList<>();
            }
        } catch (IOException e) {
            System.err.println("Failed to show accounts: " + e.getMessage());
            users = new ArrayList<>();
        }
    }
    public void createUserAccount(String fullName, String username, String password) {
        Optional<Users> existingAccount = users.stream().filter(a -> a.getUserName().equals(username)).findFirst();
        if (existingAccount.isPresent()) {
            System.out.println("Account with username " + username + " already exists.");
            return;
        }
        try {
            Users newUsers = new Users(fullName, username, password);
            users.add(newUsers);
            objectMapper.writeValue(usersFile, users);
        } catch (IOException e) {
            System.err.println("Failed to create account: " + e.getMessage());
        }
    }

    public void viewUsersDetails(String username) {
        Optional<Users> account = users.stream().filter(a -> a.getUserName().equals(username)).findFirst();
        if (account.isPresent()) {
            System.out.println(account.get());
        } else {
            System.out.println("Account with username " + username + " does not exist.");
        }
    }
}

