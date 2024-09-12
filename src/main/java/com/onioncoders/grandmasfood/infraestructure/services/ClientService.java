package com.onioncoders.grandmasfood.infraestructure.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onioncoders.grandmasfood.api.models.request.ClientRequest;
import com.onioncoders.grandmasfood.api.models.responses.ClientResponse;
import com.onioncoders.grandmasfood.domain.entities.ClientEntity;
import com.onioncoders.grandmasfood.domain.repositories.ClientRepository;
import com.onioncoders.grandmasfood.domain.repositories.OrderRepository;
import com.onioncoders.grandmasfood.infraestructure.abstract_services.IClientService;

import lombok.var;
import lombok.extern.slf4j.Slf4j;

@Transactional
@Service
@Slf4j
public class ClientService implements IClientService {

    private final ClientRepository clientRepository;
    private final OrderRepository orderRepository;

    public ClientService(OrderRepository orderRepository, ClientRepository clientRepository) {
        this.orderRepository = orderRepository;
        this.clientRepository=clientRepository;
    }

    @Override
    public ClientResponse create(ClientRequest request) {
        var clientToPersist= ClientEntity.builder()
            .id(UUID.randomUUID())
            .deliveryAddress(request.getDeliveryAddress())
            .document(request.getDocument())
            .email(request.getEmail())
            .name(request.getName())
            .phone(request.getPhone())
            .tipoID(request.getTipoID())
            .build();

        var clientPersisted =this.clientRepository.save(clientToPersist);

        log.info("Client saved with id: {}",clientPersisted.getDocument());
            
        return this.entityToResponse(clientPersisted);
    }

    @Override
    public ClientResponse read(UUID uuid) {
        var clientFromDB = this.clientRepository.findById(uuid).orElseThrow();
        return this.entityToResponse(clientFromDB);
    }

    public List<ClientEntity> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public ClientResponse update(ClientRequest request, UUID uuid) {
       ClientEntity existClient = clientRepository.findById(uuid).orElseThrow();

       existClient.setDocument(request.getDocument());
       existClient.setName(request.getName());
       existClient.setPhone(request.getPhone());
       existClient.setDeliveryAddress(request.getDeliveryAddress());

        return entityToResponse(existClient);
    }

    @Override
    public void delete(UUID uuid) {
        var clientToDelete = clientRepository.findById(uuid).orElseThrow();
        this.clientRepository.delete(clientToDelete);
    }

    @Override
    public ClientResponse findByEmail(String email) {
        ClientEntity client = clientRepository.findByEmail(email);
        return entityToResponse(client) ;
    }

    @Override
    public ClientResponse findByDocument(String document) {
        var client = clientRepository.findByDocument(document);
        
        return entityToResponse(client);
    }

    private ClientResponse entityToResponse(ClientEntity entity){
        var response = new ClientResponse();
        BeanUtils.copyProperties(entity, response);

        return response;   
    }




}
