package com.store.controllers;

import com.store.models.Client;
import com.store.models.requests.ClientRequest;
import com.store.models.responses.ClientResponse;
import com.store.services.ClientService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * This class is responsible for defining all explicit REST calls that can be done that are related to the {@link Client}.
 *
 */
@Controller
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(value = "/client")
    public ResponseEntity createClient(@RequestBody ClientRequest client) {
        Long id = clientService.createClient(client);
        return new ResponseEntity<>(new ClientResponse(id), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/client/{clientId}")
    public ResponseEntity deleteClient(@ApiParam(value = "clientId", example = "434233") @PathVariable Long clientId) {
        clientService.deleteClient(clientId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PatchMapping(value = "/client")
    public ResponseEntity updateClient(@RequestBody Client client) {
        Long id = clientService.updateClient(client);
        return new ResponseEntity<>(new ClientResponse(id), HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/client/{clientId}")
    public ResponseEntity<Client> findClient(@ApiParam(value = "clientId", example = "434233") @PathVariable Long clientId) {
        Client client = clientService.findClient(clientId);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }
}
