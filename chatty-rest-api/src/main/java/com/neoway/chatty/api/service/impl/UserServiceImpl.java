package com.neoway.chatty.api.service.impl;

import com.neoway.chatty.api.domain.User;
import com.neoway.chatty.api.domain.UserRepository;
import com.neoway.chatty.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(userRepository.findByUsernameCanonical(username.toLowerCase()));
    }

    @Override
    public void purchaseMessage(User user) {
        user.discount(1L);
        userRepository.save(user);
    }

    @Override
    public void save(User user) {
        user.setUsernameCanonical(user.getUsername().toLowerCase());
        userRepository.save(user);
    }


}


