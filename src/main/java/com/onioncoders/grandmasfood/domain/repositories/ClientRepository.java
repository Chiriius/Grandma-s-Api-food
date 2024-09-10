package com.onioncoders.grandmasfood.domain.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onioncoders.grandmasfood.domain.entities.ClientEntity;


public interface ClientRepository extends JpaRepository<ClientEntity,UUID> {

    ClientEntity findByEmail(String email);
    ClientEntity findByDocument(String document);


}
