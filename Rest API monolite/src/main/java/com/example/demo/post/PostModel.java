package com.example.demo.post;

import com.example.demo.user.UserModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class PostModel {
    @Id
    @GeneratedValue
    private int id;

    private String title;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private UserModel user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "PostModel{" +
                "id=" + id +
                ", user=" + user +
                ", title='" + title + '\'' +
                '}';
    }
}
