package com.example.perfermencedemo.controller;

import com.example.perfermencedemo.dto.UserDto;
import com.example.perfermencedemo.entity.User;
import com.example.perfermencedemo.entity.UserRepository;
import com.example.perfermencedemo.services.UserService;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariPoolMXBean;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController2 {

    private final UserService userService;
    private final HikariDataSource dataSource;

    @PostMapping("user/save")
    public List<UserDto> createUser(@RequestBody User user) throws InterruptedException {
        HikariPoolMXBean poolMXBean = dataSource.getHikariPoolMXBean();
        var list = userService.createNewUser(user);
        Thread.sleep(5 * 1000);
        System.out.println("createUserController2: wait 5 seconds");
        System.out.println("Active Connections: " + poolMXBean.getActiveConnections());
        System.out.println("Idle Connections: " + poolMXBean.getIdleConnections());
        System.out.println("Total Connections: " + poolMXBean.getTotalConnections());
        return list;
    }
}
