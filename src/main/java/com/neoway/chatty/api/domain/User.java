package com.neoway.chatty.api.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

import java.util.Date;

import static java.util.Objects.nonNull;


@Document(collection = "users")
public class User {

    @Id
    private String id;

    @NotNull(message = "username might not be null")
    private String username;

    @NotNull(message = "name might not be null")
    private String name;

    private Long budget;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    @CreatedDate
    private Date createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    @LastModifiedDate
    private Date updatedAt;

    @Version
    protected Long version;

    public User(){
        //A new user might have 10 credits to send messages throuth the app
        this.budget = 10L;
    }

    public static User of(String name, String username){
        User user = new User();
        user.setName(name);
        user.setUsername(username);
        return user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public boolean hasBudget(){
        return nonNull(budget) && budget > 0;
    }

    public void discount(Long discount){
        setBudget(getBudget() - discount);
    }

}
