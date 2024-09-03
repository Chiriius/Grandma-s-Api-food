package com.onioncoders.grandmasfood.api.models.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ClientResponse {
    
    private String document;
    private String name;
    private String email;
    private Integer phone;
    private String deliveryAddress;
    
}
