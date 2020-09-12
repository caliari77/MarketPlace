package com.store.services;


import com.store.exceptions.UnprocessableEntityException;
import com.store.models.ShoppingCart;
import com.store.models.requests.ShoppingCartRequest;
import com.store.repositories.ShoppingCartRepository;
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
class ShoppingCartServiceTest {

    @Mock
    private ShoppingCartRepository repository;
    private ShoppingCartService service;
    private final long expectedIdFromShoppingCart = 1234567;

    @BeforeEach
    public void setUp() {
        service = new ShoppingCartService(repository);
    }

    @Test
    public void whenCreateShoppingCartShouldReturnId() {

        ShoppingCart expectedShoppingCart = new ShoppingCart();
        expectedShoppingCart.setId(expectedIdFromShoppingCart);
        when(repository.save(any())).thenReturn(expectedShoppingCart);

        Long result = service.createShoppingCart(new ShoppingCartRequest());

        assertThat(result)
                .isNotNull()
                .isEqualTo(expectedIdFromShoppingCart);
    }

    @Test
    public void whenDeleteShoppingCartShouldReturnOk() {

        ShoppingCart expectedShoppingCart = new ShoppingCart();
        expectedShoppingCart.setId(expectedIdFromShoppingCart);

        boolean result = service.deleteShoppingCart(expectedIdFromShoppingCart);

        assertTrue(result);
    }

    @Test
    public void whenFindShoppingCartShouldReturnShoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(expectedIdFromShoppingCart);
        when(repository.findById(any())).thenReturn(Optional.of(shoppingCart));

        ShoppingCart result = service.findShoppingCart(expectedIdFromShoppingCart);

        assertThat(result).isNotNull();
        assertThat(result.getId())
                .isNotNull()
                .isEqualTo(expectedIdFromShoppingCart);
    }

    @Test
    public void whenCreateShoppingCartShouldReturnUnprocessableEntityException() {
        when(repository.save(any())).thenReturn(null);

        Assertions.assertThrows(UnprocessableEntityException.class, () -> {
            service.createShoppingCart(new ShoppingCartRequest());
        });
    }
}