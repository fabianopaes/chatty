package com.neoway.chatty.api.events.handler;

import com.neoway.chatty.api.events.Event;

/**
 * This interface can be implemented to handle different types of messages.
 * Every handler is responsible for a single of type message
 * @param <E> Handler can handle events of type E
 */
public interface Handler<E extends Event> {

    /**
     * The onEvent method should implement and handle behavior related to the event.
     * @param event the {@link Event} object to be handled.
     */
    void onEvent(E event);

}
