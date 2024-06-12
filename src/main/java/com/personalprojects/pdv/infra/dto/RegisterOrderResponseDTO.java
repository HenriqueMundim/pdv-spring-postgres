package com.personalprojects.pdv.infra.dto;

import com.personalprojects.pdv.domain.entities.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterOrderResponseDTO {

    private UUID id;

    private UserDomainOutputDTO client;

    private Instant date;

    private Set<OrderItem> itens = new HashSet<>();
}
