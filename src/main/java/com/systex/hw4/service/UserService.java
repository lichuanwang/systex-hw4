package com.systex.hw4.service;


import com.systex.hw4.model.User;
import com.systex.hw4.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean registerUser(User user) {
        // Save the user (password should be encrypted in real applications)
        userRepository.save(user);
        return true;
    }

    public boolean authenticateUser(String username, String password) {
        return userRepository.findByUsername(username).isPresent() && password.equals(userRepository.findByUsername(username).get().getPassword());
    }

    public boolean authenticateUser(String username) {
        return userRepository.findByUsername(username).isPresent();
    }
}