package com.store.controllers;


import com.store.models.Client;
import com.store.models.requests.ClientRequest;
import com.store.models.responses.ClientResponse;
import com.store.repositories.ClientRepository;
import com.store.services.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientControllerTest {

    @Mock
    private ClientRepository repository;
    private ClientService clientService;
    private ClientController controller;

    @BeforeEach
    public void setUp() {
        clientService = new ClientService(repository);
        controller = new ClientController(clientService);
    }

    @Test
    public void whenCreateClientShouldReturnStatusCreated() {
        long expectedIdFromClient = 1234567;

        Client expectedClient = new Client();
        expectedClient.setId(expectedIdFromClient);
        when(repository.save(any())).thenReturn(expectedClient);

        ResponseEntity<ClientResponse> result = controller.createClient(new ClientRequest("Buzz Lightyear", "1123434456", 31));

        assertThat(result.getBody()).isNotNull();
        assertThat(result.getStatusCode())
                .isNotNull()
                .isEqualTo(HttpStatus.CREATED);
        assertThat(result.getBody().getId())
                .isNotNull()
                .isEqualTo(expectedIdFromClient);
    }

    @Test
    public void whenDeleteClientShouldReturnStatusOk() {

        ResponseEntity result = controller.deleteClient(1L);

        assertThat(result.getBody()).isNull();
        assertThat(result.getStatusCode())
                .isNotNull()
                .isEqualTo(HttpStatus.OK);
    }

    @Test
    public void whenFindClientShouldReturnStatusOk() {
        long expectedIdFromClient = 1234567L;

        Client expectedClient = new Client();
        expectedClient.setId(expectedIdFromClient);
        when(repository.findById(eq(expectedIdFromClient))).thenReturn(Optional.of(expectedClient));

        ResponseEntity<Client> result = controller.findClient(expectedIdFromClient);

        assertThat(result.getBody()).isNotNull();
        assertThat(result.getStatusCode())
                .isNotNull()
                .isEqualTo(HttpStatus.OK);
        assertThat(result.getBody().getId())
                .isNotNull()
                .isEqualTo(expectedIdFromClient);
    }

    @Test
    public void whenUpdateClientShouldReturnStatusAccepted() {
        long expectedIdFromClient = 1234567;

        Client client = new Client();
        client.setId(expectedIdFromClient);

        Client expectedClient = new Client();
        expectedClient.setId(expectedIdFromClient);

        when(repository.save(any())).thenReturn(expectedClient);

        ResponseEntity<ClientResponse> result = controller.updateClient(client);

        assertThat(result.getBody()).isNotNull();
        assertThat(result.getStatusCode())
                .isNotNull()
                .isEqualTo(HttpStatus.ACCEPTED);
        assertThat(result.getBody().getId())
                .isNotNull()
                .isEqualTo(expectedIdFromClient);
    }
}