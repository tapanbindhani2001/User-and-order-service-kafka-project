package com.tapan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<UserCode> handleException(DataNotFoundException ex)
    {
        UserCode code = new UserCode();
        code.setCode("Unable to find record from server");
        code.setSuccess(false);
        code.setDateTime(LocalDateTime.now());
        code.setMessage(ex.getMessage());
        code.setStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(code,HttpStatus.NOT_FOUND);
    }
}
