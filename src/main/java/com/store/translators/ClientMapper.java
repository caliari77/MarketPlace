package com.store.translators;

import com.store.models.Client;
import com.store.models.requests.ClientRequest;
import org.mapstruct.Mapper;

/**
 * This is a simple translator class that uses the auto generated map struct framework to
 * convert types of POJO's that are related to the {@link Client}.
 */
@Mapper
public interface ClientMapper {

    Client clientRequestToClient(ClientRequest clientRequest);
}
