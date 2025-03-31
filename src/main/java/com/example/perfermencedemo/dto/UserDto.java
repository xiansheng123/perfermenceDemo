package com.example.perfermencedemo.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String email;

}
