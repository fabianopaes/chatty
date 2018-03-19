package com.neoway.chatty.api.domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends MongoRepository<Message, String> {

    @Query("{ 'from' : ?0}")
    List<Message> findBySender(String sender);

    @Query("{ 'to' : ?0}")
    List<Message> findByRecipient(String recipient);

}