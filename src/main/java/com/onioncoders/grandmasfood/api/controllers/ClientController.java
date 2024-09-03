package com.onioncoders.grandmasfood.api.controllers;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.onioncoders.grandmasfood.api.models.request.ClientRequest;
import com.onioncoders.grandmasfood.api.models.responses.ClientResponse;
import com.onioncoders.grandmasfood.infraestructure.abstract_services.IClientService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RequestMapping(path = "clients")
@RestController
@AllArgsConstructor
public class ClientController {

    private final IClientService clientService;


    @PostMapping
    public ResponseEntity<ClientResponse> post(@RequestBody ClientRequest request){

        return ResponseEntity.ok(clientService.create(request));

    }

    @GetMapping(path = "{id}")
    public ResponseEntity<ClientResponse> get(@PathVariable UUID id) {
        return ResponseEntity.ok(clientService.read(id));
    }

    // @GetMapping(path = "email/{email}")
    // public ResponseEntity<ClientResponse> getByEmail(@PathVariable String email) {
    //     return ResponseEntity.ok(clientService.ra);
    // }



    
    
}
