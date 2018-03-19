package com.neoway.chatty.api.service;

import com.neoway.chatty.api.domain.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findById(String id);

    Iterable<User> findAll();

    Optional<User> findByUsername(String userName);

    void purchaseMessage(User user);

    void save(User user);

}
