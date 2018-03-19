package com.neoway.chatty.api.repository;


import com.neoway.chatty.api.config.MongoConfig;
import com.neoway.chatty.api.domain.Message;
import com.neoway.chatty.api.domain.MessageRepository;
import com.neoway.chatty.api.support.DomainFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoConfig.class)
public class MessageRepositoryTest {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private MongoOperations mongoOps;

    @Before
    public void testSetup() {
        if (!mongoOps.collectionExists(Message.class)) {
            mongoOps.createCollection(Message.class);
        }
    }

    @After
    public void tearDown() {
        mongoOps.dropCollection(Message.class);
    }

    @Test
    public void whenSavingMessageFillOutAllMandatoryField() {
        messageRepository.save(DomainFactory.createMessage());
        messageRepository.findAll().forEach( message -> {
            assertNotNull(message.getId());
            assertNotNull(message.getSentAt());
            assertNotNull(message.getBody());
            assertNotNull(message.getTo());
            assertNotNull(message.getFrom());
        });

    }

    @Test
    public void shouldBeAbleToRetrieveAMessageByUserSender(){
        Message message = DomainFactory.createMessage();
        messageRepository.save(message);
        messageRepository.findBySender(message.getFrom()).forEach( fromDb -> {
            assertEquals(message.getId(), fromDb.getId());
            assertEquals(message.getSentAt(),fromDb.getSentAt());
            assertEquals(message.getBody(), fromDb.getBody());
            assertEquals(message.getTo(), fromDb.getTo());
            assertEquals(message.getFrom(),fromDb.getFrom());
        });
    }

    @Test
    public void shouldBeAbleToRetrieveAMessageByUserReceipt(){
        Message message = DomainFactory.createMessage();
        messageRepository.save(message);
        messageRepository.findBySender(message.getTo()).forEach( fromDb -> {
            assertEquals(message.getId(), fromDb.getId());
            assertEquals(message.getSentAt(),fromDb.getSentAt());
            assertEquals(message.getBody(), fromDb.getBody());
            assertEquals(message.getTo(), fromDb.getTo());
            assertEquals(message.getFrom(),fromDb.getFrom());
        });
    }

}
