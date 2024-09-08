package com.onioncoders.grandmasfood.infraestructure.services;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onioncoders.grandmasfood.api.models.request.CategoryRequest;
import com.onioncoders.grandmasfood.api.models.responses.CategoryResponse;
import com.onioncoders.grandmasfood.api.models.responses.ClientResponse;
import com.onioncoders.grandmasfood.domain.entities.CategoryEntity;
import com.onioncoders.grandmasfood.domain.entities.ClientEntity;
import com.onioncoders.grandmasfood.domain.repositories.CategoryRepository;
import com.onioncoders.grandmasfood.infraestructure.abstract_services.ICategoryService;

import lombok.extern.slf4j.Slf4j;

@Transactional
@Service
@Slf4j
public class CategoryService implements ICategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryResponse create(CategoryRequest request) {
        var categoryToPersist = CategoryEntity.builder()
        .name(request.getName())
        .description(request.getDescription())
        .build();

     var categoryPersisted = this.categoryRepository.save(categoryToPersist);
     log.info("Category saved with name: {}",categoryPersisted.getName());
     return this.entityToResponse(categoryPersisted);
    }

    @Override
    public CategoryResponse read(Long id) {
        var clientFromDB = this.categoryRepository.findById(id).orElseThrow();
        return this.entityToResponse(clientFromDB);
    }

    @Override
    public CategoryResponse update(CategoryRequest request, Long id) {
        var categoryToUpdate = categoryRepository.findById(id).orElseThrow();
        
        categoryToUpdate.setName(request.getName());
        categoryToUpdate.setDescription(request.getDescription());

        var categoryUpdated= this.categoryRepository.save(categoryToUpdate);
        log.info("Category updated with id {}",categoryToUpdate.getId());

        return this.entityToResponse(categoryUpdated);
    }

    @Override
    public void delete(Long id) {
        var categoryToDelete = this.categoryRepository.findById(id).orElseThrow();
        this.categoryRepository.delete(categoryToDelete);


    }

        private CategoryResponse entityToResponse(CategoryEntity entity){
        var response = new CategoryResponse();
        BeanUtils.copyProperties(entity, response);

        return response;   
    }
}
