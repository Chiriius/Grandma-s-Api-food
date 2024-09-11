package com.onioncoders.grandmasfood.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="Combo")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ComboEntity {

    @Id
    private Long id;
    private String name;
    private String description;
    private Double priceWithoutTax;

    @ManyToOne
    @JoinColumn(name = "category_fk", nullable = false)
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "product_fk", nullable = false)
    private ProductEntity product;

}
