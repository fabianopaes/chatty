package com.neoway.chatty.api.events;

import java.util.Date;
import java.util.UUID;

public class AbstractEvent implements Event {

/*
    private String uuidd;

    private Date dateTime;

    private EventType type;

    public AbstractEvent(EventType type) {
        this.uuidd = UUID.randomUUID().toString();
        this.dateTime = new Date();
        this.type = type;
    }

    */
/**
     * Returns the event type as a {@link Class} object
     * In this example, this method is used by the {@link EventDispatcher} to
     * dispatch events depending on their type.
     *
     * @return the AbstractEvent type as a {@link Class}.
     *//*

    @Override
    public EventType getType() {
        return type;
    }

    @Override
    public String getUuidd() {
        return uuidd;
    }

    @Override
    public Date getDateTime() {
        return dateTime;
    }
*/


    /**
     * Returns the event type as a {@link Class} object
     * In this example, this method is used by the {@link EventDispatcher} to
     * dispatch events depending on their type.
     *
     * @return the AbstractEvent type as a {@link Class}.
     */
    public Class<? extends Event> getType() {
        return getClass();
    }
}