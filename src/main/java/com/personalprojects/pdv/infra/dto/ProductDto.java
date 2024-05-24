package com.personalprojects.pdv.infra.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class ProductDto {

    private String id;

    @EqualsAndHashCode.Exclude
    private String description;

    @EqualsAndHashCode.Exclude
    private Double price;

    @EqualsAndHashCode.Exclude
    private String imageUrl;
}
