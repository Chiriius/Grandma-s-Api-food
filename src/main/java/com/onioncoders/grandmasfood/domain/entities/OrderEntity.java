package com.onioncoders.grandmasfood.domain.entities;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "pedidos")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class OrderEntity {

    @Id
    private UUID id;
    @Column(name = "creationdatetime")
    private LocalDateTime creationDateTime;
    @Column(length = 100)
    private Integer quantity;
    @Column(length = 511, name = "extrainformation")
    private String extraInformation;
    @Column(name = "comboFK")
    private Long combo;
    @ManyToOne
    @JoinColumn(name = "clienteFK")
    private ClientEntity client;



    
}
