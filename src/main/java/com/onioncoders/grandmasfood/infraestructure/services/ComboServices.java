package com.onioncoders.grandmasfood.infraestructure.services;

import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.onioncoders.grandmasfood.api.models.request.ComboRequest;
import com.onioncoders.grandmasfood.api.models.responses.ComboResponse;
import com.onioncoders.grandmasfood.domain.entities.ComboEntity;
import com.onioncoders.grandmasfood.domain.entities.ProductEntity;
import com.onioncoders.grandmasfood.domain.repositories.ComboRepository;
import com.onioncoders.grandmasfood.domain.repositories.ProductRepository;
import com.onioncoders.grandmasfood.infraestructure.Helpers.ForeignKeyHelper;
import com.onioncoders.grandmasfood.infraestructure.abstract_services.IComboService;

import lombok.var;

public class ComboServices implements IComboService {

    private final ProductRepository productRepository;
    private final ComboRepository comboRepository;

    private ForeignKeyHelper foreignKeyHelper;

   

    public ComboServices(ProductRepository productRepository,ComboRepository comboRepository , ForeignKeyHelper foreignKeyHelper) {
        this.productRepository = productRepository;
        this.foreignKeyHelper = foreignKeyHelper;
        this.comboRepository = comboRepository;
    }

    @Override
    public ComboResponse create(ComboRequest request) {
        UUID productID = request.getProduct_fk();

        ProductEntity product = foreignKeyHelper.getProductById(productID);

        var comboToPersist = ComboEntity.builder()
        .id(UUID.randomUUID())
        .name(request.getName())
        .extrainformation(request.getExtraInformation())
        .quantity(request.getQuantity())
        .product(product)
        .build();

        var comboToPersisted = this.comboRepository.save(comboToPersist);

        return this.entityToResponse(comboToPersisted);
    }

    @Override
    public ComboResponse read(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public ComboResponse update(ComboRequest request, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }


     private ComboResponse entityToResponse(ComboEntity entity){
        var response = new ComboResponse();
        BeanUtils.copyProperties(entity, response);

        return response;
     } 
    
}
