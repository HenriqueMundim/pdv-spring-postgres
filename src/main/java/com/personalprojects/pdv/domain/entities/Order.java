package com.personalprojects.pdv.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy 'T' HH:mm:ss")
    private Instant date;

    @Transient
    private Double totalPrice;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User client;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    public Order(Instant date, User user) {
        this.date = date;
        this.client = user;
    }

    public Double getTotalPrice() {
        double sum = 0.0;
        for (OrderItem item : items) {
            sum += item.getQuantity() * item.getId().getProduct().getPrice();
        }

        return sum;
    }

}
