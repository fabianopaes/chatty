package com.neoway.chatty.api.web;

import com.neoway.chatty.api.domain.resource.ErrorResource;
import com.neoway.chatty.api.exception.UserHasNoBudgetException;
import com.neoway.chatty.api.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorResource> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ErrorResource.notFound(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserHasNoBudgetException.class)
    public final ResponseEntity<ErrorResource> handleUserHasNoBudgetException(UserHasNoBudgetException ex, WebRequest request) {
        return new ResponseEntity<>(ErrorResource.badRequest(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
