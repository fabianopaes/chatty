package com.neoway.chatty.api.service;

import com.neoway.chatty.api.domain.User;

import java.util.Optional;

public interface UserService {

    User findById(Long id);

    Optional<User> findByIdOptional(Long id);

    void update(User originalUser, User updatedUser);

    void create(User user);

    Iterable<User> findAll();

}
