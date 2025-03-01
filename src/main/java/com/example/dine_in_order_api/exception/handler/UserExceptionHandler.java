package com.example.dine_in_order_api.exception.handler;

import com.example.dine_in_order_api.exception.UserNotFoundByIdException;
import com.example.dine_in_order_api.utility.ResponseBuilder;
import com.example.dine_in_order_api.utility.SimpleErrorStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UserNotFoundByIdException.class)
    public ResponseEntity<SimpleErrorStructure> getMessage(UserNotFoundByIdException ex){
        return ResponseBuilder.error(HttpStatus.NOT_FOUND , ex.getMessage());
    }
}
