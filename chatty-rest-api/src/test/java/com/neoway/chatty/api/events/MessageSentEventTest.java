package com.neoway.chatty.api.events;

import com.neoway.chatty.api.support.DomainFactory;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class MessageSentEventTest {

    @Test
    public void testGetEventType() {

        MessageSentEvent event =  MessageSentEvent.create(
                DomainFactory.createUser("sender", "sender"),
                DomainFactory.createUser("receipt", "receipt"),
                new Date(), "here comes the message"
        );

        assertEquals(MessageSentEvent.class, event.getType());
    }
}
