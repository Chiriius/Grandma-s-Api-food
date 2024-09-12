package com.onioncoders.grandmasfood.domain.entities;

import java.util.UUID;

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
    private UUID id;
    private String name;
    private Integer quantity;
    private Double priceWithoutTax;
    private String extrainformation;

    @ManyToOne
    @JoinColumn(name = "category_fk", nullable = false)
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "product_fk", nullable = false)
    private ProductEntity product;

}
