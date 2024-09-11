package com.onioncoders.grandmasfood.domain.entities;

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
    @Column(name = "combofk")
    private Long combo;
    @ManyToOne
    @JoinColumn(name = "clientefk")
    private ClientEntity client;



    
}
