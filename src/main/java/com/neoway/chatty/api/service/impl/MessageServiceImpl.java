package com.neoway.chatty.api.service.impl;

import com.neoway.chatty.api.domain.Message;
import com.neoway.chatty.api.domain.MessageRepository;
import com.neoway.chatty.api.domain.User;
import com.neoway.chatty.api.service.MessageService;
import com.neoway.chatty.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MessageServiceImpl implements MessageService{


    private UserService userService;

    private MessageRepository messageRepository;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setMessageRepository(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void send(Message message) {

        User userSource = userService.findByUsernameOptional(message.getFrom())
                .orElseThrow(null);

        if(! userSource.hasBudget()){
            throw new RuntimeException("The user has no budget to sent the message");
        }

        User userTarget = userService.findByUsernameOptional(message.getTo())
                .orElseThrow(null);

        save(message);

        userService.purchaseMessage(userSource);
    }

    @Override
    public void save(Message message) {
        messageRepository.save(message);
    }

    @Override
    public Iterable<Message> findAll() {
        return null;
    }
}
