package com.example.a1796122.databaseapp;

public class User {
    public User(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    String name;
    String address;
    String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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



}
