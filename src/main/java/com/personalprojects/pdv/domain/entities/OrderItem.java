package com.personalprojects.pdv.domain.entities;

import com.personalprojects.pdv.domain.entities.pk.OrderItemPK;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class OrderItem {

    @EmbeddedId
    private OrderItemPK id;

    @Column(nullable = false)
    @EqualsAndHashCode.Exclude
    private Integer quantity;

    public OrderItem(Order order, Product product, Integer quantity) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
    }

}
