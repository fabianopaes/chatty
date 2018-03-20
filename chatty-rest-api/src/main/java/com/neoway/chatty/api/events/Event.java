package com.neoway.chatty.api.events;

public interface Event {

    Class<? extends Event> getType();

}
