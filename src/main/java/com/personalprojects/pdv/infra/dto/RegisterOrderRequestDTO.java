package com.personalprojects.pdv.infra.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterOrderRequestDTO {

    @NotNull(message = "Date is required")
    @NotBlank(message = "Date is required")
    @JsonFormat(pattern = "dd/MM/yyyy 'T' HH:mm:ss")
    private Instant date;

    @NotNull(message = "User ID is required")
    @NotBlank(message = "User ID is required")
    private UUID userId;
}
