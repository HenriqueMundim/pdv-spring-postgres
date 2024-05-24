package com.personalprojects.pdv.infra.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@Setter
@Getter
public class CreateUserRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String name;

    private String email;

    private String password;

    public CreateUserRequest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

}
