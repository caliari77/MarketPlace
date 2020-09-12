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


@Service
public class ClientService {

    private ClientRepository clientRepository;

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

        if(persistedClient == null) {
            throw new UnprocessableEntityException(CREATE_CLIENT, CREATE_CLIENT_FAILURE);
        }

        return persistedClient.getId();
    }

    public Client findClient(long clientId) {
        return clientRepository.findById(clientId).orElseThrow(() -> new NotFoundException(FIND_CLIENT, CLIENT_NOT_FOUND));
    }
}
