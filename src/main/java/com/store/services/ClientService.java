package com.store.services;

import com.store.exceptions.NotFoundException;
import com.store.exceptions.UnprocessableEntityException;
import com.store.models.Client;
import com.store.models.requests.ClientRequest;
import com.store.repositories.ClientRepository;
import com.store.translators.ClientMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import static com.store.Constants.*;

/**
 * This is a service that operates all the hypothetical business cases related the {@link com.store.controllers.ClientController}.
 */
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public boolean deleteClient(Long clientId) {
        clientRepository.deleteById(clientId);
        return true;
    }

    public Long updateClient(Client client) {
        Client persistedClient = clientRepository.save(client);
        return persistedClient.getId();
    }

    public Long createClient(ClientRequest clientRequest) {
        ClientMapper mapper = Mappers.getMapper(ClientMapper.class);
        Client persistedClient = clientRepository.save(mapper.clientRequestToClient(clientRequest));

        return persistedClient.getId();
    }

    public Client findClient(long clientId) {
        return clientRepository.findById(clientId).orElseThrow(() -> new NotFoundException(FIND_CLIENT, CLIENT_NOT_FOUND));
    }
}
