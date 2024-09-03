package com.onioncoders.grandmasfood.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onioncoders.grandmasfood.domain.entities.ClientEntity;
import java.util.List;
import java.util.Set;
import java.util.UUID;


public interface ClientRepository extends JpaRepository<ClientEntity,UUID> {

    Set<ClientEntity> findByEmail(String email);
    Set<ClientEntity> findByDocument(String document);

}
