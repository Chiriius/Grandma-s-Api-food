package com.onioncoders.grandmasfood.infraestructure.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.onioncoders.grandmasfood.api.models.request.ProductRequest;
import com.onioncoders.grandmasfood.api.models.responses.ProductResponse;
import com.onioncoders.grandmasfood.domain.entities.CategoryEntity;
import com.onioncoders.grandmasfood.domain.entities.ProductEntity;
import com.onioncoders.grandmasfood.domain.repositories.CategoryRepository;
import com.onioncoders.grandmasfood.domain.repositories.ProductRepository;
import com.onioncoders.grandmasfood.infraestructure.Helpers.ForeignKeyHelper;
import com.onioncoders.grandmasfood.infraestructure.abstract_services.IProductService;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Transactional
@Service
@Slf4j
public class ProductService implements IProductService  {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private  ForeignKeyHelper foreignKeyHelper;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository, ForeignKeyHelper foreignKeyHelper){
        this.productRepository= productRepository;
        this.categoryRepository= categoryRepository;
        this.foreignKeyHelper= foreignKeyHelper;
    }

    @Override
    public ProductResponse create(ProductRequest request) {

        Long categoryId = request.getCategoryFK();

        CategoryEntity category = foreignKeyHelper.getCategoryById(categoryId);

            var productToPersist= ProductEntity.builder()
            .id(UUID.randomUUID())
            .name(request.getName())
            .description(request.getDescription())
            .stock(request.getStock())
            .price(request.getPrice())
            .category(category)
            .available(request.getAvailable())
            .build();


        var productPersisted =this.productRepository.save(productToPersist);
        log.info("Product saved with id: {}",productPersisted.getId());

        return this.entityToResponse(productPersisted);
    }

    @Override
    public ProductResponse read(UUID uuid) {
        var productFromDB = this.productRepository.findById(uuid).orElseThrow();
        return this.entityToResponse(productFromDB);
    }

    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public ProductResponse update(ProductRequest request, UUID uuid) {
        
        
        ProductEntity ProductToUpdate = productRepository.findById(uuid).orElseThrow();

        ProductToUpdate.setName(request.getName());
        ProductToUpdate.setDescription(request.getDescription());
        ProductToUpdate.setPrice(request.getPrice());
        ProductToUpdate.setStock(request.getStock());
        ProductToUpdate.setAvailable(request.getAvailable());

        
        return entityToResponse(ProductToUpdate);
    }

    @Override
    public void delete(UUID uuid) {
        var ProductToDelete = productRepository.findById(uuid).orElseThrow();
        this.productRepository.delete(ProductToDelete);


    }

        private ProductResponse entityToResponse(ProductEntity entity){
        var response = new ProductResponse();
        BeanUtils.copyProperties(entity, response);

        return response;   
    }
}
