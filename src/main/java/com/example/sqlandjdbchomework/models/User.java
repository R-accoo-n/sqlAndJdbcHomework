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
@AllArgsConstructor
@ToString
public class User {
    private int id;
    private String username;
    private String email;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
