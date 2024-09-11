package com.onioncoders.grandmasfood.api.models.responses;

import com.onioncoders.grandmasfood.domain.entities.CategoryEntity;
import com.onioncoders.grandmasfood.domain.entities.ProductEntity;

import jakarta.persistence.Id;

public class ComboResponse {
    @Id
    private Long id;
    private String name;
    private String description;
    private Double priceWithoutTax;
    private ProductEntity product_fk;
    private CategoryEntity category_fk;
}
