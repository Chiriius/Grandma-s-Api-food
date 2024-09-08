package com.onioncoders.grandmasfood.domain.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.onioncoders.grandmasfood.domain.entities.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity,UUID>{}
    
