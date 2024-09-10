package com.onioncoders.grandmasfood.api.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onioncoders.grandmasfood.api.models.request.ClientRequest;
import com.onioncoders.grandmasfood.api.models.responses.ClientResponse;
import com.onioncoders.grandmasfood.domain.entities.ClientEntity;
import com.onioncoders.grandmasfood.infraestructure.abstract_services.IClientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;



@Tag(name = "Client")
@RequestMapping(path = "v1/clients")
@RestController
@AllArgsConstructor
public class ClientController {

    private final IClientService clientService;


    @Operation(summary = "Save in system a client")
    @PostMapping
    public ResponseEntity<ClientResponse> post(@RequestBody ClientRequest request){

        return ResponseEntity.ok(clientService.create(request));

    }

    @Operation(summary = "Return a client with id passed")
    @GetMapping(path = "{id}")
    public ResponseEntity<ClientResponse> get(@PathVariable UUID id) {
        return ResponseEntity.ok(clientService.read(id));
    }
    @GetMapping("/list")
    public List<ClientEntity> getAllClients() {
        return clientService.getAllClients();
    }

    @Operation(summary = "Actualiza a client with id passed")
    @PutMapping( path = "{id}")
    public ResponseEntity<Void> put(@PathVariable UUID id, @RequestBody ClientRequest entity) {
        this.clientService.update(entity, id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Removed a client from db")
    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        this.clientService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @Operation(summary = "Return a client with email passed")
    @GetMapping(path = "/email/{email}")
    public ResponseEntity<ClientResponse> getByEmail(@PathVariable String email) {
        return ResponseEntity.ok(clientService.findByEmail(email));
    }

    @Operation(summary = "Return a client with document passed")
    @GetMapping(path = "/document/{document}")
    public ResponseEntity<ClientResponse> getByDocument(@PathVariable String document) {
        return ResponseEntity.ok(clientService.findByDocument(document));
    }



    
    
}
