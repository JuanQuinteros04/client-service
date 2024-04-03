package com.client.controller;

import com.commons.client.model.DTO.ClientDTO;
import com.commons.client.model.DTO.ClientResponse;
import com.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClientResponse>> findAllClients(){
        return ResponseEntity.ok(clientService.findAllClients());
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientResponse>findClientById(@PathVariable("id")Long id){
        return ResponseEntity.ok(clientService.findClientById(id));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientResponse>createClient(@RequestBody ClientDTO clientDTO){

        ClientResponse clientResponse = clientService.createClient(clientDTO);


        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(clientResponse.getId())
                .toUri();
        return ResponseEntity.created(location).body(clientResponse);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>updateClient(@PathVariable("id")Long id, @RequestBody ClientDTO clientDTO){
        clientService.updateClient(id, clientDTO);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>deleteClient(@PathVariable("id")Long id){
        clientService.deleteClient(id);
        return ResponseEntity.status(204).build();
    }
}

