package com.onioncoders.grandmasfood.api.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.onioncoders.grandmasfood.api.models.request.CategoryRequest;
import com.onioncoders.grandmasfood.api.models.responses.CategoryResponse;
import com.onioncoders.grandmasfood.infraestructure.abstract_services.ICategoryService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RequestMapping(path = "v1/category")
@RestController
@AllArgsConstructor
public class CategoryController {

    private final ICategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponse> post(@RequestBody CategoryRequest request){
        return ResponseEntity.ok(categoryService.create(request));
    }
    
    @GetMapping (path = "{id}")
    public ResponseEntity<CategoryResponse> get(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.read(id));
    }

    @PutMapping (path = "{id}")
    public ResponseEntity<Void> put(@PathVariable Long id,@RequestBody CategoryRequest request){
        this.categoryService.update(request, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping (path = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.categoryService.delete(id);
        return ResponseEntity.noContent().build();

    }
    
}
