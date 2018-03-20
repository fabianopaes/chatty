package com.neoway.chatty.api.events;

public class AbstractEvent implements Event {

    public Class<? extends Event> getType() {
        return getClass();
    }
}