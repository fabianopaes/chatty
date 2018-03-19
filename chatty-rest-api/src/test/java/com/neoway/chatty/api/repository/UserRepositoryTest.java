package com.neoway.chatty.api.repository;

import com.neoway.chatty.api.config.MongoConfig;
import com.neoway.chatty.api.domain.User;
import com.neoway.chatty.api.domain.UserRepository;
import com.neoway.chatty.api.support.DomainFactory;
import com.neoway.chatty.api.utils.Constants;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoConfig.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoOperations mongoOps;

    @Before
    public void testSetup() {
        if (!mongoOps.collectionExists(User.class)) {
            mongoOps.createCollection(User.class);
        }
    }

    @After
    public void tearDown() {
        mongoOps.dropCollection(User.class);
    }


    @Test
    public void whenSavingUserFillingOutAllMandatoryField() {
        userRepository.save(DomainFactory.createUser());
        userRepository.findAll().forEach( user -> {
            assertNotNull(user.getId());
            assertNotNull(user.getCreatedAt());
            assertNotNull(user.getUpdatedAt());
            assertNotNull(user.getBudget());
            assertNotNull(user.getUsernameCanonical());
            assertEquals(user.getUsernameCanonical(), user.getUsername().toLowerCase());
            assertEquals(Constants.DEFAULT_BUDGET, user.getBudget());
        });
    }

    @Test
    public void shouldUpdateTheUpdatedAtFieldWhenSomeDataHasChange() {
        User user = DomainFactory.createUser();
        userRepository.save(user);
        user.discount(1L);
        userRepository.save(user);
        assertNotEquals(user.getUpdatedAt(), user.getCreatedAt());
    }
}
