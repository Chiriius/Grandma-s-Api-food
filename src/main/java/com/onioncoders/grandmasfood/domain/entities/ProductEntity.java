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

@Entity (name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductEntity {

    @Id
    private UUID id;
    private String name;
    private Integer price;
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "categoryfk")
    private CategoryEntity category;
    
}
