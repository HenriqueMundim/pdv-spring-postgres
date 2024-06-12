package com.personalprojects.pdv.infra.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterOrderRequestDTO {

    private Instant date;

    @NotNull(message = "User ID is required")
    @NotBlank(message = "User ID is required")
    private String userId;
}
