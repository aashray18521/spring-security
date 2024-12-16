package org.personalprojects.springsecurity.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record SignupRequest(
        @NotBlank(message="Name cannot be blank")
        String name,

        @Email
        @NotBlank(message = "Email cannot be blank")
        String email,

        @NotBlank(message = "Password cannot be blank")
        @Size(min=6, max=28, message="Password must be between 6 to 28 characters")
        String password
) {
}
