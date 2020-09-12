package com.store.repositories;

import com.store.models.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Basic interface that uses Spring JPA auto generated CRUD for the {@link Client} entity.
 */
@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {


}
