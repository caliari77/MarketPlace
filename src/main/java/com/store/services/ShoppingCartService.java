package com.store.services;

import com.store.exceptions.NotFoundException;
import com.store.exceptions.UnprocessableEntityException;
import com.store.models.ShoppingCart;
import com.store.models.requests.ShoppingCartRequest;
import com.store.repositories.ShoppingCartRepository;
import com.store.translators.ShoppingCartMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.store.Constants.*;

/**
 * This is a service that operates all the hypothetical business cases related the {@link com.store.controllers.ShoppingCartController}.
 */
@Service
public class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;

    @Autowired
    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public Long createShoppingCart(ShoppingCartRequest shoppingCartRequest) {
        ShoppingCartMapper mapper = Mappers.getMapper(ShoppingCartMapper.class);
        ShoppingCart persistedShoppingCart = shoppingCartRepository.save(mapper.shoppingCartRequestToShoppingCart(shoppingCartRequest));

        return persistedShoppingCart.getId();
    }

    public boolean deleteShoppingCart(Long shoppingCartId) {
        shoppingCartRepository.deleteById(shoppingCartId);
        return true;
    }

    public ShoppingCart findShoppingCart(Long shoppingCartId) {
        return shoppingCartRepository.findById(shoppingCartId).orElseThrow(() -> new NotFoundException(FIND_SHOPPING_CART, SHOPPING_CART_NOT_FOUND));
    }
}
