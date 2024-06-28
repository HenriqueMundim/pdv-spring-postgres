package com.personalprojects.pdv.infra.daos;

import com.personalprojects.pdv.domain.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderJpaDao extends JpaRepository<Order, UUID> {
    @Query("SELECT or FROM Order or WHERE or.client.id = ?1")
    public Optional<List<Order>>findOrderByUser(UUID id);
}
