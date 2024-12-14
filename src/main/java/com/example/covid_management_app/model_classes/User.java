package com.example.covid_management_app.model_classes;

import java.io.Serializable;
import java.time.LocalDate;

public class User implements Serializable {
    private String email, name, password, address, phone, role;
    LocalDate dob, regDate;

    public User(String email, String name, String password, String address, String phone, String role, LocalDate dob, LocalDate regDate) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.role = role;
        this.dob = dob;
        this.regDate = regDate;

    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }
}
