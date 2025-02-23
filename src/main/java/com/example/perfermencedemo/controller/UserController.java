package com.example.perfermencedemo.controller;

import com.example.perfermencedemo.entity.User;
import com.example.perfermencedemo.entity.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("user/all")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("user/save")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
