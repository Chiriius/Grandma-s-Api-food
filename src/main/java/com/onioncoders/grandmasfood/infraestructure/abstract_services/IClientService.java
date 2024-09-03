package com.onioncoders.grandmasfood.infraestructure.abstract_services;

import java.util.UUID;

import com.onioncoders.grandmasfood.api.models.request.ClientRequest;
import com.onioncoders.grandmasfood.api.models.responses.ClientResponse;

public interface IClientService extends CrudService<ClientRequest,ClientResponse,UUID> {
    
}
