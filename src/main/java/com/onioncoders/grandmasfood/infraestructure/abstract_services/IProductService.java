package com.onioncoders.grandmasfood.infraestructure.abstract_services;

import java.util.List;
import java.util.UUID;

import com.onioncoders.grandmasfood.api.models.request.ProductRequest;
import com.onioncoders.grandmasfood.api.models.responses.ProductResponse;
import com.onioncoders.grandmasfood.domain.entities.ProductEntity;

public interface IProductService extends CrudService<ProductRequest,ProductResponse,UUID> {
     List<ProductEntity> getAllProducts();
}
