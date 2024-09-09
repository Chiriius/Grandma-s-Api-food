package com.onioncoders.grandmasfood.api.models.request;

import java.util.UUID;

import com.onioncoders.grandmasfood.domain.entities.CategoryEntity;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductRequest {
    private String name;
    private String description;
    private Boolean available;
    private Integer price;
    private Integer stock;
    private CategoryEntity categoryFK;
    
}
