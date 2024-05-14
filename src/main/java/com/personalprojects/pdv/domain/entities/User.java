package com.personalprojects.pdv.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode()
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @EqualsAndHashCode.Exclude
    @Column(length = 100, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @EqualsAndHashCode.Exclude
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();

}
