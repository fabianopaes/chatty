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

        User sender = userService.findByUsername(message.getFrom())
                .orElseThrow(null);

        if(! sender.hasBudget()){
            throw new RuntimeException("The user has no budget to sent the message");
        }

        userService.findByUsername(message.getTo())
                .orElseThrow(null);

        save(message);

        userService.purchaseMessage(sender);
    }

    @Override
    public void save(Message message) {
        messageRepository.save(message);
    }

    @Override
    public Iterable<Message> findAll() {
        return null;
    }

    @Override
    public Iterable<Message> findByRecipient(Long id) {
        return null;
    }
}
