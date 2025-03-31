package com.example.perfermencedemo.services;

import com.example.perfermencedemo.dto.UserDto;
import com.example.perfermencedemo.entity.User;
import com.example.perfermencedemo.entity.UserRepository;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariPoolMXBean;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final HikariDataSource dataSource;

    public List<UserDto> createNewUser(@RequestBody User user) throws InterruptedException {
        HikariPoolMXBean poolMXBean = dataSource.getHikariPoolMXBean();
        var newUser = userRepository.save(user);
        Thread.sleep(5 * 1000);
        System.out.println("createNewUser: after wait 5 seconds");
        System.out.println("Active Connections: " + poolMXBean.getActiveConnections());
        System.out.println("Idle Connections: " + poolMXBean.getIdleConnections());
        System.out.println("Total Connections: " + poolMXBean.getTotalConnections());

        List<User> list = userRepository.findAll();
        Thread.sleep(5 * 1000);
        System.out.println("createNewUser: after wait more 5 seconds");
        System.out.println("Active Connections: " + poolMXBean.getActiveConnections());
        System.out.println("Idle Connections: " + poolMXBean.getIdleConnections());
        System.out.println("Total Connections: " + poolMXBean.getTotalConnections());
        return list.stream().map(x -> new UserDto(x.getId(), x.getName(), x.getEmail())).toList();
    }

}
