package com.onioncoders.grandmasfood.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.onioncoders.grandmasfood.domain.entities.ClientEntity;
import java.util.List;
import java.util.Set;
import java.util.UUID;


public interface ClientRepository extends CrudRepository<ClientEntity,UUID> {

    ClientEntity findByEmail(String email);
    ClientEntity findByDocument(String document);


}
