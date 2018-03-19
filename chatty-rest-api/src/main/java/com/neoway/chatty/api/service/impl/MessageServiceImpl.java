package com.neoway.chatty.api.service.impl;

import com.neoway.chatty.api.domain.Message;
import com.neoway.chatty.api.domain.MessageRepository;
import com.neoway.chatty.api.domain.User;
import com.neoway.chatty.api.exception.UserHasNoBudgetException;
import com.neoway.chatty.api.exception.UserNotFoundException;
import com.neoway.chatty.api.service.MessageService;
import com.neoway.chatty.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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
                .orElseThrow(()->new UserNotFoundException("not found the sender user", message.getFrom()));


        userService.findByUsername(message.getTo())
                .orElseThrow(()->new UserNotFoundException("not found the recipient user", message.getTo()));

        if(! sender.hasBudget()){
            throw new UserHasNoBudgetException(
                    "The user has no budget to sent the message", sender.getId());
        }

        save(message);

        userService.purchaseMessage(sender);
    }

    @Override
    public void save(Message message) {
        messageRepository.save(message);
    }

    @Override
    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    @Override
    public List<Message> findByRecipientUsername(String id) {
        return messageRepository.findByRecipient(id);
    }
}
