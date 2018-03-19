package com.neoway.chatty.api.events.handler;

import com.neoway.chatty.api.events.MessageSentEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MessageSentEventHandler implements Handler<MessageSentEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageSentEvent.class);

    /**
     *  This is a dummy handler for a while, you can use it to send message to receipt.
     *
     *  At this point you use some async process to send to receipt, i.e some pub/sub way
     * @param event the {@link Event} object to be handled.
     */
    @Override
    public void onEvent(MessageSentEvent event) {
        LOGGER.info("User '{}' has sent a message to '{}' with content '{}'...",
                event.getSender().getUsername(), event.getReceipt().getUsername(), event.getContent());
    }

}
