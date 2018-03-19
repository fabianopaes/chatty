package com.neoway.chatty.api.domain;

import com.neoway.chatty.api.utils.Constants;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void userShouldHave10AsBudgetAfterCreating(){
        User user = new User();
        assertEquals(Constants.DEFAULT_BUDGET, user.getBudget());
    }
}
