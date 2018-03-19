package com.neoway.chatty.api.events;

import com.neoway.chatty.api.domain.User;

import java.util.Date;

public class MessageSentEvent  extends AbstractEvent {

    private User sender;
    private User receipt;
    private Date sentAt;
    private String content;

    public static MessageSentEvent create(User sender, User receipt, Date sentAt, String content){
        MessageSentEvent event = new MessageSentEvent();
        event.sender = sender;
        event.receipt = receipt;
        event.sentAt = sentAt;
        event.content = content;
        return event;
    }

    public User getSender() {
        return sender;
    }

    public User getReceipt() {
        return receipt;
    }

    public Date getSentAt() {
        return sentAt;
    }

    public String getContent() {
        return content;
    }

}
