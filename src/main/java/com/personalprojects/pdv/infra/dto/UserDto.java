package com.personalprojects.pdv.infra.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.personalprojects.pdv.domain.entities.Order;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class UserDto {

    private String id;

    @EqualsAndHashCode.Exclude
    private String name;

    private String email;

    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private String password;

    private List<Order> orders = new ArrayList<>();

}
