package com.onioncoders.grandmasfood.infraestructure.abstract_services;


import java.util.UUID;

import com.onioncoders.grandmasfood.api.models.request.ComboRequest;
import com.onioncoders.grandmasfood.api.models.responses.ComboResponse;


public interface IComboService extends CrudService<ComboRequest,ComboResponse,UUID> {

    
}
