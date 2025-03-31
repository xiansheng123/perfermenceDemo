//package com.example.perfermencedemo.controller;
//
//import com.example.perfermencedemo.entity.User;
//import com.example.perfermencedemo.entity.UserRepository;
//import com.zaxxer.hikari.HikariDataSource;
//import com.zaxxer.hikari.HikariPoolMXBean;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//public class UserController {
//
//    private final UserRepository userRepository;
//
//    private final HikariDataSource dataSource;
//    @GetMapping("user/all")
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    @PostMapping("user/save")
//    public List<User> createUser(@RequestBody User user) throws InterruptedException {
//        HikariPoolMXBean poolMXBean = dataSource.getHikariPoolMXBean();
//        var newUser = userRepository.save(user);
//        Thread.sleep(5 * 1000);
//        System.out.println("after wait 5 seconds");
//        System.out.println("Active Connections: " + poolMXBean.getActiveConnections());
//        System.out.println("Idle Connections: " + poolMXBean.getIdleConnections());
//        System.out.println("Total Connections: " + poolMXBean.getTotalConnections());
//
//        List<User> list = userRepository.findAll();
//        Thread.sleep(5 * 1000);
//        System.out.println("after wait more 5 seconds");
//        System.out.println("Active Connections: " + poolMXBean.getActiveConnections());
//        System.out.println("Idle Connections: " + poolMXBean.getIdleConnections());
//        System.out.println("Total Connections: " + poolMXBean.getTotalConnections());
//        return list;
//    }
//}
