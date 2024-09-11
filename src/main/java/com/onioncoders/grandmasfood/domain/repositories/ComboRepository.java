package com.onioncoders.grandmasfood.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onioncoders.grandmasfood.domain.entities.ComboEntity;

public interface ComboRepository extends JpaRepository <ComboEntity, Long>{
    
}
