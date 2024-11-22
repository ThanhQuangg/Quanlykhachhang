package com.example.customermanagement.service;

import com.example.customermanagement.pojo.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Integer userId);
    User createUser(User user);
    User updateUser(Integer userId, User user);
    void deleteUser(Integer userId);
}

