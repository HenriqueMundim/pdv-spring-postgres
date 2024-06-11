package com.personalprojects.pdv.infra.dto;

import com.personalprojects.pdv.domain.enums.UserRole;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RegisterUserResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private UUID id;

    private String name;

    private String email;

    private String username;

}
