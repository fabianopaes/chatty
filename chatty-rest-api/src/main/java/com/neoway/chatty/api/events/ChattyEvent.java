package com.neoway.chatty.api.events;

import java.util.Date;
import java.util.UUID;

public class ChattyEvent {

    private String uuidd;

    private Date dateTime;

    private EventType type;

    public ChattyEvent(EventType type){
        this.uuidd = UUID.randomUUID().toString();
        this.dateTime = new Date();
        this.type = type;
    }

    public String getUuidd() {
        return uuidd;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public EventType getType() {
        return type;
    }

}
