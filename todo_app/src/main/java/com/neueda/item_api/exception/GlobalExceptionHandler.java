package com.neueda.item_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ItemNotFoundException.class)
    @ResponseBody
    public ResponseEntity handleItemNotFoundException(ItemNotFoundException itemNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(itemNotFoundException.getParam());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity handleGenericException(Exception exception){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
    }

    @ExceptionHandler(InvalidParamsException.class)
    @ResponseBody
    public ResponseEntity handleInvalidParamsException(InvalidParamsException invalidParamsException){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(invalidParamsException.getParam());
    }
}

