package com.example.perfermencedemo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

}
