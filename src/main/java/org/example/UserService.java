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

    }
}

