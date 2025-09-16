package com.tapan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ApiResponse> handleException(DataNotFoundException ex)
    {
        ApiResponse response = new ApiResponse();
        response.setCode("FAILED");
        response.setDateTime(LocalDateTime.now());
        response.setMessage(false);
        response.setStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

}
