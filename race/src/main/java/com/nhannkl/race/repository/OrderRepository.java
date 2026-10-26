package com.nhannkl.race.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nhannkl.race.model.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
