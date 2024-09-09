package com.onioncoders.grandmasfood.domain.repositories;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onioncoders.grandmasfood.domain.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {

    
}