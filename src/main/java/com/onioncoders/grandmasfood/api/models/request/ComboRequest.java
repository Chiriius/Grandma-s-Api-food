package com.onioncoders.grandmasfood.api.models.request;

import java.util.UUID;

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
    private String name;
    private String extraInformation;
    private int quantity;
    private UUID product_fk;
}
