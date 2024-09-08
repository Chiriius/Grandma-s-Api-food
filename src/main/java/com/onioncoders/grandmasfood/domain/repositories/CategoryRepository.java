package com.onioncoders.grandmasfood.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.onioncoders.grandmasfood.domain.entities.CategoryEntity;

public interface CategoryRepository extends CrudRepository<CategoryEntity,Long>{

    
} 
