package com.onioncoders.grandmasfood.api.models.request;

import com.onioncoders.grandmasfood.utils.enums.TypeID;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ClientRequest {

    @Enumerated(EnumType.STRING)
    private TypeID tipoID;  
    private String document;
    private String name;
    private String email;
    private Integer phone;
    private String deliveryAddress;
    
}
