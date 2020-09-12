package com.store.controllers;

import com.store.models.ShoppingCart;
import com.store.models.requests.ShoppingCartRequest;
import com.store.models.responses.ShoppingCartResponse;
import com.store.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * This class is responsible for defining all explicit REST calls that can be done that are related to the {@link ShoppingCart}.
 *
 */
@Controller
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping(value = "/ShoppingCart")
    public ResponseEntity createShoppingCart(@RequestBody ShoppingCartRequest shoppingCartRequest) {
        Long id = shoppingCartService.createShoppingCart(shoppingCartRequest);
        return new ResponseEntity<>(new ShoppingCartResponse(id), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/ShoppingCart/{shoppingCartId}")
    public ResponseEntity deleteShoppingCart(@PathVariable Long shoppingCartId) {
        shoppingCartService.deleteShoppingCart(shoppingCartId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/ShoppingCart/{shoppingCartId}")
    public ResponseEntity<ShoppingCart> findShoppingCart(@PathVariable Long shoppingCartId) {
        ShoppingCart ShoppingCart = shoppingCartService.findShoppingCart(shoppingCartId);
        return new ResponseEntity<>(ShoppingCart, HttpStatus.OK);
    }
}
