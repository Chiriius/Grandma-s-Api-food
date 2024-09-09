package com.onioncoders.grandmasfood.api.models.responses;

import java.util.UUID;

import com.onioncoders.grandmasfood.domain.entities.CategoryEntity;

public class ProductResponse {
    private UUID id;
    private String name;
    private Integer price;
    private String description;
    private Integer stock;
    private Boolean available;
    private CategoryEntity categoryEntity;
    
}
