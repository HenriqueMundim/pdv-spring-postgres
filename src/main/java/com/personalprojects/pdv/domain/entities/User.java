package com.personalprojects.pdv.domain.entities;

import jakarta.persistence.*;
import lombok.*;

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
    @Column(length = 100)
    private String name;

    @Column(unique = true)
    private String email;

    @EqualsAndHashCode.Exclude
    private String password;

}
