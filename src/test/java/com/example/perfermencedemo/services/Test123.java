package com.example.perfermencedemo.services;

import lombok.Getter;
import lombok.ToString;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class Test123 {

    @Test
    public void test() {
        String aa = Optional.ofNullable("test").orElse(print());
        String bb = Optional.ofNullable("test").orElseGet(() -> print());
        String cc = Optional.ofNullable("test").orElseThrow(() -> {
            System.out.println("error");
            return new RuntimeException("cannot be null");
        });
        // String dd = Optional.ofNullable(null).orElseThrow();
        System.out.println("result aa | bb");
    }

    private String print() {
        System.out.println("123");
        return "or else";
    }


    @Getter
    @ToString
    enum Color {
        RED("r","this is red"),
        GREEN("g","this is green"),
        BLUE("b","this is blue");

        public final String label;
        public final String description;

        Color(String name,String desc) {
            this.label = name;
            this.description =desc;
        }
    }
}


