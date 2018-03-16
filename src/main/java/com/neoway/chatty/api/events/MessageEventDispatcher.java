package com.neoway.chatty.api.events;

public interface MessageEventDispatcher {

    void onEvent(MessageEvent event);
}
