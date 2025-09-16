package com.tapan.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserCode {
    private String code;
    private String message;
    private boolean success;
    private LocalDateTime dateTime;
    private HttpStatus status;
}
