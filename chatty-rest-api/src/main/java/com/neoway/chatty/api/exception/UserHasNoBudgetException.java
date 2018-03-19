package com.neoway.chatty.api.exception;

public class UserHasNoBudgetException extends BaseUserException{

    public UserHasNoBudgetException(String message, String id) {
        super(message, id);
    }
}
