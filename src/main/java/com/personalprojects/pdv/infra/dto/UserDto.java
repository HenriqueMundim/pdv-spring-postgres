package com.personalprojects.pdv.infra.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.personalprojects.pdv.domain.entities.Order;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonPropertyOrder(value = { "id", "name", "email" })
public class UserDto extends RepresentationModel<UserDto> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private String key;

    @EqualsAndHashCode.Exclude
    private String name;

    private String email;

    @EqualsAndHashCode.Exclude
    private String password;

    @JsonIgnore
    private List<Order> orders = new ArrayList<>();

    @JsonIgnore
    public String getPassword() {
        return password;
    }
    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

}
