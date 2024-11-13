package com.tje.users;

import java.time.LocalDateTime;
import java.util.Date;

public class User {
    private int id;
    private String name;
    private int age;
    private UserType userType;

    public LocalDateTime registrationDate;

    public User(int id, String name, int age, UserType userType, LocalDateTime registrationDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.userType = userType;
        this.registrationDate = registrationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public static enum UserType {
        GUEST, REGISTERED, ADMIN
    }
}
