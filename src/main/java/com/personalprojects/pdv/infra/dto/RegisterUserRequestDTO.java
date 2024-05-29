package com.personalprojects.pdv.infra.dto;

import com.personalprojects.pdv.domain.enums.UserRole;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegisterUserRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotNull(message = "Name is required")
    @NotBlank(message = "Name is required")
    @Schema(examples = "Henrique")
    private String name;

    @NotNull(message = "Email is required")
    @NotBlank(message = "Email is required")
    @Email
    @Schema(examples = "henrique@email.com")
    private String email;

    @NotNull(message = "Username is required")
    @NotBlank(message = "Username is required")
    @Size(min = 8, max = 16, message = "Username must have between 8 and 16 characters")
    private String username;

    @NotNull(message = "Password is required")
    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 16, message = "Password must have between 8 and 16 characters")
    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).*", message = "Password must have at least 1 uppercase character, 1 number and 1 special character")
    @Schema(examples = "Password@123")
    private String password;

    private UserRole role;

}
