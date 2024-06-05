package com.personalprojects.pdv.domain.entities;

import com.personalprojects.pdv.domain.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode()
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @EqualsAndHashCode.Exclude
    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 25, nullable = false, unique = true)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @EqualsAndHashCode.Exclude
    @Column(nullable = false)
    private String password;

    @EqualsAndHashCode.Exclude
    @Column(nullable = false)
    private UserRole role;

    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.role == UserRole.ADMIN ? List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER")) : List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    public User(String name, String username, String email, String password, UserRole role) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
