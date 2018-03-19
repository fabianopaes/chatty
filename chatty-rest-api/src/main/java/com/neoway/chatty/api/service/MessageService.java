package com.neoway.chatty.api.service;

import com.neoway.chatty.api.domain.Message;

import java.util.List;

public interface MessageService {

    void send(Message message);

    void save(Message user);

    List<Message> findAll();

    List<Message> findByRecipientUsername(String id);
}
