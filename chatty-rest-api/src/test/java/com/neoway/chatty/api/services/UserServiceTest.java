package com.neoway.chatty.api.services;

import com.neoway.chatty.api.domain.User;
import com.neoway.chatty.api.domain.UserRepository;
import com.neoway.chatty.api.service.impl.UserServiceImpl;
import com.neoway.chatty.api.utils.Constants;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    private UserServiceImpl userService;
    private UserRepository userRepositoryMock;

    @Before
    public void initialize(){
        userRepositoryMock = Mockito.mock(UserRepository.class);
        userService = new UserServiceImpl();
        userService.setUserRepository(userRepositoryMock);
    }

    @Test
    public void whenUserSendAMessagePurchaseFromHesBudget(){
        User user = new User();
        assertEquals("User should have 10 of budget when its created", Constants.DEFAULT_BUDGET, user.getBudget());
        when(userRepositoryMock.save(user)).thenReturn(user);

        userService.purchaseMessage(user);
        assertEquals("User should have 9 of budget after purchase a message", (Constants.DEFAULT_BUDGET.intValue() -1), user.getBudget().intValue());
    }

}
