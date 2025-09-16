package com.tapan.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_collection")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {
    @Id
    private String id;
    @NotBlank
    @NotNull
    private String name;
    @NotNull
    @NotBlank
    @Email
    private String email;

}
