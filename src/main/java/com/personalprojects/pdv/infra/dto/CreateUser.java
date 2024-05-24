package com.personalprojects.pdv.infra.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
public class CreateUser implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(examples = "Henrique")
    private String name;

    @Schema(examples = "henrique@email.com")
    private String email;

    @Schema(examples = "Senha123")
    private String password;

}
