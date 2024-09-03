package com.onioncoders.grandmasfood.domain.entities;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import com.onioncoders.grandmasfood.utils.enums.TypeID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "clientes")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class ClientEntity {
    @Id 
    @Column(length = 32)
    private UUID id;
    @Column(length = 20)
    private String document;
    @Column(length = 255)
    private String name;
    @Column(length = 255)
    private String email;
    @Column(length = 10,name = "numerocel")
    private Integer phone;
    @Column(name = "direccionenvio")
    private String deliveryAddress;
    @Enumerated(EnumType.STRING)
    @Column(name= "tipoid")
    private TypeID tipoID;  

    @OneToMany(
        cascade = CascadeType.ALL,
        fetch = FetchType.EAGER,
        orphanRemoval = true,
        mappedBy = "client"
    )
    private Set<OrderEntity> orders;
}
