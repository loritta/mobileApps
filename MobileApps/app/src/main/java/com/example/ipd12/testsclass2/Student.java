package com.example.ipd12.testsclass2;

/**
 * Created by ipd12 on 8/8/2018.
 */

class Student {
    String id;
    String name;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    String address;
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Student(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address=address;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
