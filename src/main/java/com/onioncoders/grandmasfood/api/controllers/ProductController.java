package com.onioncoders.grandmasfood.api.controllers;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onioncoders.grandmasfood.api.models.request.ProductRequest;
import com.onioncoders.grandmasfood.api.models.responses.ProductResponse;
import com.onioncoders.grandmasfood.infraestructure.abstract_services.IProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;

@Tag(name = "Product")
@RequestMapping(path = "v1/product")
@RestController
@AllArgsConstructor
public class ProductController {

    private final IProductService productService;

    @Operation(summary = "Save in system a product")
    @PostMapping
    public ResponseEntity<ProductResponse> post(@RequestBody ProductRequest request){
        return ResponseEntity.ok(productService.create(request));
    }

    @Operation(summary = "Return a product with id passed")
    @GetMapping(path = "{id}")
    public ResponseEntity<ProductResponse> get(@PathVariable UUID id){
        return ResponseEntity.ok(productService.read(id));
    }
    
    
}
