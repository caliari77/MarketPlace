package com.store.repositories;

import com.store.models.ShoppingCart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Basic interface that uses Spring JPA auto generated CRUD for the {@link ShoppingCart} entity.
 */
@Repository
public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {

}
