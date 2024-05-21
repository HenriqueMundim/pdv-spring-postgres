package com.personalprojects.pdv.infra.Dto;

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
    private String password;

    private List<Order> orders = new ArrayList<>();

}
