package com.example.demo.user;

import com.example.demo.post.PostModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity(name="user_model")
public class UserModel {
    //REST API METHODS
    //GET -> give a resource
    //POST -> create a new resource
    //PUT -> update a resource
    //DELETE -> remove a resource
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonProperty("user_name")
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    @JsonProperty("user_age")
    private int age;

    @OneToMany(mappedBy = "user") //field of post model
    private List<PostModel> posts;

    //add default constructor for query
    public UserModel(){ }

    public UserModel(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + age +
                '}';
    }


    public List<PostModel> getPosts() {
        return posts;
    }

    public void setPosts(List<PostModel> posts) {
        this.posts = posts;
    }
}
