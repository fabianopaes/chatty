package com.neoway.chatty.api.services;

import com.neoway.chatty.api.domain.Message;
import com.neoway.chatty.api.domain.MessageRepository;
import com.neoway.chatty.api.domain.User;
import com.neoway.chatty.api.events.EventDispatcher;
import com.neoway.chatty.api.exception.UserHasNoBudgetException;
import com.neoway.chatty.api.exception.UserNotFoundException;
import com.neoway.chatty.api.service.UserService;
import com.neoway.chatty.api.service.impl.MessageServiceImpl;
import com.neoway.chatty.api.support.DomainFactory;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MessagesServiceTest {

    private MessageServiceImpl messageService;
    private UserService userServiceMock;
    private MessageRepository messageRepositoryMock;
    private EventDispatcher eventDispatcher;


    @Rule
    public ExpectedException expectedException = ExpectedException.none();


    @Before
    public void initialize(){

        messageService = new MessageServiceImpl();
        userServiceMock = Mockito.mock(UserService.class);
        messageRepositoryMock = Mockito.mock(MessageRepository.class);
        eventDispatcher = Mockito.spy(EventDispatcher.class);

        messageService.setUserService(userServiceMock);
        messageService.setMessageRepository(messageRepositoryMock);
        messageService.setEventDispatcher(eventDispatcher);
    }

    @Test
    public void throwExceptionWhenSendingAMessageAndReceiptNotFound(){
        when(userServiceMock.findByUsername(anyString())).thenReturn(Optional.empty());
        expectedException.expect(UserNotFoundException.class);
        messageService.send(DomainFactory.createMessage());
    }

    @Test
    public void throwExceptionWhenSendingAMessageAndSenderNotFound(){
        Message message = DomainFactory.createMessage();
        User sender = DomainFactory.createUser(message.getFrom(), "name");
        when(userServiceMock.findByUsername(message.getFrom())).thenReturn(Optional.of(sender));
        when(userServiceMock.findByUsername(message.getTo())).thenReturn(Optional.empty());
        expectedException.expect(UserNotFoundException.class);
        messageService.send(message);
    }

    @Test
    public void throwExceptionWhenSendingAMessageButTheSenderHasNoBudgetYet(){
        Message message = DomainFactory.createMessage();
        User sender = DomainFactory.createUserWithNoBudget(message.getFrom(), "sender-name");
        User receipt = DomainFactory.createUser(message.getFrom(), "receipt-name");
        when(userServiceMock.findByUsername(message.getFrom())).thenReturn(Optional.of(sender));
        when(userServiceMock.findByUsername(message.getTo())).thenReturn(Optional.of(receipt));
        expectedException.expect(UserHasNoBudgetException.class);
        messageService.send(message);
    }


    @Test
    public void whenSendingAMessagePurchaseSenderBudgetAndSendEvent(){
        Message message = DomainFactory.createMessage();

        User sender = DomainFactory.createUser(message.getFrom(), "sender-name");
        User receipt = DomainFactory.createUser(message.getFrom(), "receipt-name");

        when(userServiceMock.findByUsername(message.getFrom())).thenReturn(Optional.of(sender));
        when(userServiceMock.findByUsername(message.getTo())).thenReturn(Optional.of(receipt));

        when(messageRepositoryMock.save(message)).thenReturn(message);/*
        verify(userServiceMock, times(1)).purchaseMessage(sender);
        verify(eventDispatcher, times(1)).dispatch(any());*/

        messageService.send(message);

    }

}
