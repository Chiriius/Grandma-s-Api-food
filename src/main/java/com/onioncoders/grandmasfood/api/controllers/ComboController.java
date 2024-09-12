package com.onioncoders.grandmasfood.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onioncoders.grandmasfood.api.models.request.ComboRequest;
import com.onioncoders.grandmasfood.api.models.responses.ComboResponse;
import com.onioncoders.grandmasfood.infraestructure.abstract_services.IComboService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Tag(name="Combo")
@RequestMapping(path ="v1/combo")
@RestController
@AllArgsConstructor
public class ComboController {

    private final IComboService comboService;

    @PostMapping("path")
    public ResponseEntity<ComboResponse> post(@RequestBody ComboRequest request) {
        
        return ResponseEntity.ok(comboService.create(request));
    }
    

}
