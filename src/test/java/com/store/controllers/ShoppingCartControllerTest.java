package com.store.controllers;


import com.store.models.ShoppingCart;
import com.store.models.requests.ShoppingCartRequest;
import com.store.models.responses.ShoppingCartResponse;
import com.store.repositories.ShoppingCartRepository;
import com.store.services.ShoppingCartService;
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
class ShoppingCartControllerTest {

    @Mock
    private ShoppingCartRepository repository;
    private ShoppingCartController controller;

    @BeforeEach
    public void setUp() {
        ShoppingCartService shoppingCartService = new ShoppingCartService(repository);
        controller = new ShoppingCartController(shoppingCartService);
    }

    @Test
    public void whenCreateShoppingCartShouldReturnStatusCreated() {
        long expectedIdFromShoppingCart = 1234567;

        ShoppingCart expectedShoppingCart = new ShoppingCart();
        expectedShoppingCart.setId(expectedIdFromShoppingCart);
        when(repository.save(any())).thenReturn(expectedShoppingCart);

        ResponseEntity<ShoppingCartResponse> result = controller.createShoppingCart(new ShoppingCartRequest());

        assertThat(result.getBody()).isNotNull();
        assertThat(result.getStatusCode())
                .isNotNull()
                .isEqualTo(HttpStatus.CREATED);
        assertThat(result.getBody().getId())
                .isNotNull()
                .isEqualTo(expectedIdFromShoppingCart);
    }

    @Test
    public void whenDeleteShoppingCartShouldReturnStatusOk() {

        ResponseEntity result = controller.deleteShoppingCart(1L);

        assertThat(result.getBody()).isNull();
        assertThat(result.getStatusCode())
                .isNotNull()
                .isEqualTo(HttpStatus.OK);
    }

    @Test
    public void whenFindShoppingCartShouldReturnStatusOk() {
        long expectedIdFromShoppingCart = 1234567L;

        ShoppingCart expectedShoppingCart = new ShoppingCart();
        expectedShoppingCart.setId(expectedIdFromShoppingCart);
        when(repository.findById(eq(expectedIdFromShoppingCart))).thenReturn(Optional.of(expectedShoppingCart));

        ResponseEntity<ShoppingCart> result = controller.findShoppingCart(expectedIdFromShoppingCart);

        assertThat(result.getBody()).isNotNull();
        assertThat(result.getStatusCode())
                .isNotNull()
                .isEqualTo(HttpStatus.OK);
        assertThat(result.getBody().getId())
                .isNotNull()
                .isEqualTo(expectedIdFromShoppingCart);
    }


}