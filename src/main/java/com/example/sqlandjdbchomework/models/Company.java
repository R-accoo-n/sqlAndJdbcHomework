package com.example.sqlandjdbchomework.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Company {
    private int id;
    private String name;
    private String address;

    public Company(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
