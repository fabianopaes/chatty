package com.neoway.chatty.api.service;

import com.neoway.chatty.api.domain.Message;

public interface MessageService {

    void send(Message message);

    void save(Message user);

    Iterable<Message> findAll();
}
