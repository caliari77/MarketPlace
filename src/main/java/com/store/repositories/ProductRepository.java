package com.store.repositories;

import com.store.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Basic interface that uses Spring JPA auto generated CRUD for the {@link Product} entity.
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {


}
