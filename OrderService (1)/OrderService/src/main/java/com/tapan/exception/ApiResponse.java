package com.tapan.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApiResponse {
    private boolean message;
    private HttpStatus status;
    private LocalDateTime dateTime;
    private String code;

}
