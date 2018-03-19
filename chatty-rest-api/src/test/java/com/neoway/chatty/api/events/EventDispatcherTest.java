package com.neoway.chatty.api.events;

import com.neoway.chatty.api.events.handler.MessageSentEventHandler;
import com.neoway.chatty.api.support.DomainFactory;
import org.junit.Test;

import java.util.Date;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;


public class EventDispatcherTest {

  @Test
  public void testEventDriverPattern() {

    EventDispatcher dispatcher = spy(new EventDispatcher());

    MessageSentEvent event =  MessageSentEvent.create(
            DomainFactory.createUser("sender", "sender"),
            DomainFactory.createUser("receipt", "receipt"),
            new Date(), "here comes the message"
    );

    MessageSentEventHandler messageSentEventHandler = spy(new MessageSentEventHandler());

    dispatcher.registerHandler(MessageSentEvent.class, messageSentEventHandler);

    dispatcher.dispatch(event);
    verify(messageSentEventHandler).onEvent(event);
    verify(dispatcher).dispatch(event);

  }

}
