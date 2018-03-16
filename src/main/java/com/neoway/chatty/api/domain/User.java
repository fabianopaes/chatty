package com.neoway.chatty.api.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "username might not be null")
    private String username;

    @NotNull(message = "name might not be null")
    private String name;

    private Long budget;

    private Date createdAt;

    private Date updatedAt;


    public User(){
        //A new user might have 10 credits to send messages throuth the app
        this.budget = 10L;
        this.createdAt = new Date();

    }

    public static User of(String name, String username){
        User user = new User();
        user.setName(name);
        user.setUsername(username);
        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PreUpdate
    public void preUpdate(){
        updatedAt = new Date();
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
