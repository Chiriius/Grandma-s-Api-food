package com.onioncoders.grandmasfood.api.models.request;

import com.onioncoders.grandmasfood.domain.entities.CategoryEntity;
import com.onioncoders.grandmasfood.domain.entities.ProductEntity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ComboRequest {
    @Id
    private Long id;
    private String name;
    private String description;
    private Double priceWithoutTax;
    private ProductEntity product_fk;
    private CategoryEntity category_fk;
}
