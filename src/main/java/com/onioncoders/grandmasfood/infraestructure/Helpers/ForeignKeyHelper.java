package com.onioncoders.grandmasfood.infraestructure.Helpers;


import java.util.UUID;

import org.springframework.stereotype.Service;

import com.onioncoders.grandmasfood.domain.entities.CategoryEntity;
import com.onioncoders.grandmasfood.domain.entities.ComboEntity;
import com.onioncoders.grandmasfood.domain.entities.ProductEntity;
import com.onioncoders.grandmasfood.domain.repositories.CategoryRepository;
import com.onioncoders.grandmasfood.domain.repositories.ComboRepository;
import com.onioncoders.grandmasfood.domain.repositories.ProductRepository;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class ForeignKeyHelper {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    

    public CategoryEntity getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Category not found with ID: " + categoryId));
}
public ProductEntity getProductById(UUID productID) {
    return productRepository.findById(productID)
            .orElseThrow(() -> new IllegalArgumentException("product not found with ID: " + productID));
}

}