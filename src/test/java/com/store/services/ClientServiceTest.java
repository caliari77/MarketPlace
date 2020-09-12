package com.store.services;


import com.store.exceptions.UnprocessableEntityException;
import com.store.models.Client;
import com.store.models.requests.ClientRequest;
import com.store.repositories.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    @Mock
    private ClientRepository repository;
    private ClientService service;
    private final long expectedIdFromClient = 1234567;

    @BeforeEach
    public void setUp() {
        service = new ClientService(repository);
    }

    @Test
    public void whenCreateClientShouldReturnId() {

        Client expectedClient = new Client();
        expectedClient.setId(expectedIdFromClient);
        when(repository.save(any())).thenReturn(expectedClient);

        Long result = service.createClient(new ClientRequest("Buzz Lightyear", "1123434456", 31));

        assertThat(result)
                .isNotNull()
                .isEqualTo(expectedIdFromClient);
    }

    @Test
    public void whenDeleteClientShouldReturnOk() {

        Client expectedClient = new Client();
        expectedClient.setId(expectedIdFromClient);

        boolean result = service.deleteClient(expectedIdFromClient);

        assertTrue(result);
    }

    @Test
    public void whenUpdateClientShouldReturnId() {
        Client client = new Client();
        client.setId(expectedIdFromClient);
        when(repository.save(any())).thenReturn(client);

        Long result = service.updateClient(new Client());

        assertThat(result)
                .isNotNull()
                .isEqualTo(expectedIdFromClient);
    }

    @Test
    public void whenFindClientShouldReturnClient() {
        Client client = new Client();
        client.setId(expectedIdFromClient);
        when(repository.findById(any())).thenReturn(Optional.of(client));

        Client result = service.findClient(expectedIdFromClient);

        assertThat(result).isNotNull();
        assertThat(result.getId())
                .isNotNull()
                .isEqualTo(expectedIdFromClient);
    }
}