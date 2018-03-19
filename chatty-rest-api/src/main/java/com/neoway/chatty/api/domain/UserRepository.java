package com.neoway.chatty.api.domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    @Query("{ 'usernameCanonical' : ?0}")
    User findByUsernameCanonical(String usernameCanonical);
}
