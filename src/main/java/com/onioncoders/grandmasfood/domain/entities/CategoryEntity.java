package com.onioncoders.grandmasfood.domain.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "category")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CategoryEntity {

    @Id
    private Long id;
    private String name;
    private String description;

    @OneToMany(
        cascade = CascadeType.ALL,
        fetch = FetchType.EAGER,
        orphanRemoval = true,
        mappedBy = "category"
    )
    private Set<ProductEntity> products;
}
