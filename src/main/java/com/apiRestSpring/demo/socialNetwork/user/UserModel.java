package com.apiRestSpring.demo.user;

import java.time.LocalDate;

public class UserModel {
    //REST API METHODS
    //GET -> give a resource
    //POST -> create a new resource
    //PUT -> update a resource
    //DELETE -> remove a resource

    private int id;
    private String name;
    private LocalDate birthDate;


    public UserModel(int id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }


}
