package com.example.androidrnd;

public abstract class User {
    public static String email,pass;


    public User(String email,String pass) {

        User.email = email;
        User.pass = pass;

    }

    public abstract void login();
    public abstract void register();

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        User.email = email;
    }

    public static String getPass() {
        return pass;
    }

    public static void setPass(String pass) {
        User.pass = pass;
    }
}
