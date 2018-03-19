package com.neoway.chatty.api.support;

import com.neoway.chatty.api.domain.Message;
import com.neoway.chatty.api.domain.User;

import java.util.Date;

public class DomainFactory {

    public static User createUser(){
        return createUser("iahaha-iahuhu", "iahaha.iahuhu");
    }

    public static User createUser(String username, String name){
        return User.of(username, name);
    }

    public static Message createMessage(){
        return Message.of("iahaha.iahuhu", "old.iahaha.iahuhu", "mimimi", new Date());
    }

    public static User createUserWithNoBudget(String username, String name){
        User user = createUser(username, name);
        user.setBudget(null);
        return user;
    }
}
