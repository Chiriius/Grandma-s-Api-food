package com.onioncoders.grandmasfood.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onioncoders.grandmasfood.api.models.request.CategoryRequest;
import com.onioncoders.grandmasfood.api.models.responses.CategoryResponse;
import com.onioncoders.grandmasfood.infraestructure.abstract_services.ICategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;



@Tag(name = "Category")
@RequestMapping(path = "v1/category")
@RestController
@AllArgsConstructor
public class CategoryController {

    private final ICategoryService categoryService;

    @Operation(summary = "Save in system a category")
    @PostMapping
    public ResponseEntity<CategoryResponse> post(@RequestBody CategoryRequest request){
        return ResponseEntity.ok(categoryService.create(request));
    }
    
    @Operation(summary = "Return a category with id passed")
    @GetMapping (path = "{id}")
    public ResponseEntity<CategoryResponse> get(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.read(id));
    }

    @Operation(summary = "Update a category with id passed")
    @PutMapping (path = "{id}")
    public ResponseEntity<Void> put(@PathVariable Long id,@RequestBody CategoryRequest request){
        this.categoryService.update(request, id);
        return ResponseEntity.noContent().build();
    }
    
    @Operation(summary = "Removed a category from db")
    @DeleteMapping (path = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.categoryService.delete(id);
        return ResponseEntity.noContent().build();

    }
    
}
