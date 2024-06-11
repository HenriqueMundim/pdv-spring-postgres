package com.personalprojects.pdv.infra.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.personalprojects.pdv.domain.entities.Order;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonPropertyOrder(value = { "id", "name", "email" })
public class UserDTO extends RepresentationModel<UserDTO> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private UUID key;

    private String name;

    private String email;

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

    @Override
    @Schema(hidden = true)
    public Links getLinks() {
        return super.getLinks();
    }
}
