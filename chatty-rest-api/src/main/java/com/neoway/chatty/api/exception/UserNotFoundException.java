package com.neoway.chatty.api.exception;

public class UserNotFoundException extends BaseUserException {

    public UserNotFoundException(String message, String id) {
        super(message, id);
    }
}
