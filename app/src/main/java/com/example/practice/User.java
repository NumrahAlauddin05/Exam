package com.example.practice;

public class User {
    String email;
    String pass ;
    String name;

    public User() {
    }

    public User(String email, String pass, String name) {
        this.email = email;
        this.pass = pass;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
