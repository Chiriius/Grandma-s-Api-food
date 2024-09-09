package com.onioncoders.grandmasfood.infraestructure.abstract_services;

import java.util.UUID;

import com.onioncoders.grandmasfood.api.models.request.ProductRequest;
import com.onioncoders.grandmasfood.api.models.responses.ProductResponse;

public interface IProductService extends CrudService<ProductRequest,ProductResponse,UUID> {
    
}
