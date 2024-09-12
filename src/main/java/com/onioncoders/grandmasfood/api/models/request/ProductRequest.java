package com.onioncoders.grandmasfood.api.models.request;

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
    private Long categoryFK;
    
}
