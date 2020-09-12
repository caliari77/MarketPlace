package com.store.translators;

import com.store.models.Client;
import com.store.models.requests.ClientRequest;
import org.mapstruct.Mapper;

@Mapper
public interface ClientMapper {

    Client clientRequestToClient(ClientRequest clientRequest);
}
