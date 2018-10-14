package com.example.dubbointerface.bean;

import java.io.Serializable;

public class User implements Serializable{
    private String id;
    private String name;
    private int Age;
    private String personID;
    private String address;

    public User(String id, String name, int age, String personID, String address) {
        this.id = id;
        this.name = name;
        Age = age;
        this.personID = personID;
        this.address = address;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
