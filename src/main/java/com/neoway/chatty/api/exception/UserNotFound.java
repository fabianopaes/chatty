package com.neoway.chatty.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFound extends Exception {

    public UserNotFound(String message) {
        super(message);
    }
}
