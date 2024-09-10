package com.onioncoders.grandmasfood.infraestructure.abstract_services;

import java.util.List;
import java.util.UUID;

import com.onioncoders.grandmasfood.api.models.request.ClientRequest;
import com.onioncoders.grandmasfood.api.models.responses.ClientResponse;
import com.onioncoders.grandmasfood.domain.entities.ClientEntity;

public interface IClientService extends CrudService<ClientRequest,ClientResponse,UUID> {
    ClientResponse findByEmail(String email);
    ClientResponse findByDocument(String document);
     List<ClientEntity> getAllClients();
}
