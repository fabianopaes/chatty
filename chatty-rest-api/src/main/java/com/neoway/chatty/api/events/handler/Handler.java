package com.neoway.chatty.api.events.handler;

import com.neoway.chatty.api.events.Event;

public interface Handler<E extends Event> {

    void onEvent(E event);

}
