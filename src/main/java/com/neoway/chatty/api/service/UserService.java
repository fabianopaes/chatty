package com.neoway.chatty.api.service;

import com.neoway.chatty.api.domain.User;

import java.util.Optional;

public interface UserService {

    User findById(Long id);

    Optional<User> findByIdOptional(Long id);

    void create(User user);

    Iterable<User> findAll();

    User findByUsername(String userName);

    Optional<User> findByUsernameOptional(String userName);

    void purchaseMessage(User user);

    void save(User user);


}
