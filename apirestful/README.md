package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final String FILE_PATH = "users.txt";
    private Map<Long, User> userMap = new HashMap<>();

    public UserServiceImpl() {
        loadUsersFromFile();
    }

    @Override
    public void addUser(User user) {
        userMap.put(user.getId(), user);
        writeToFile();
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public User getUserById(Long id) {
        return userMap.get(id);
    }

    @Override
    public void deleteUserById(Long id) {
        userMap.remove(id);
        writeToFile();
    }

    private void loadUsersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                Long id = Long.parseLong(fields[0].trim());
                String name = fields[1].trim();
                String email = fields[2].trim();

                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setEmail(email);

                userMap.put(id, user);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void writeToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (User user : userMap.values()) {
                writer.write(String.format("%d, %s, %s\n", user.getId(), user.getName(), user.getEmail()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}