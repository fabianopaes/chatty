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
    public User findById(Long id) {
        return userRepository.findOne("");
    }

    @Override
    public Optional<User> findByIdOptional(Long id) {
        return Optional.ofNullable(findById(id));
    }

/*    @Override
    public void update(User originalUser, User updatedUser) {
        originalUser.setUsername(updatedUser.getUsername());
        userRepository.save(originalUser);
    }*/

    @Override
    public void create(User user) {
        //validade
        userRepository.save(user);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }


    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findByUsernameOptional(String username) {
        return Optional.ofNullable(findByUsername(username));
    }

    @Override
    public void purchaseMessage(User user) {
        user.discount(1L);
        userRepository.save(user);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}


