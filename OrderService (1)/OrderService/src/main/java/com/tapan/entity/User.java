package com.tapan.entity;

import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Indexed;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {
    private String id;
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    @Email
    private String email;
}
