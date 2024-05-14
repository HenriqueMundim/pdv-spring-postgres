package com.personalprojects.pdv.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy 'T' HH:mm:ss")
    private Instant date;

    @Column(nullable = false, name = "total_price")
    private Double totalPrice;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User client;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();


    public Double getTotalPrice() {
        double sum = 0.0;
        for (OrderItem item : items) {
            sum += item.getQuantity() * item.getId().getProduct().getPrice();
        }

        return sum;
    }
}
