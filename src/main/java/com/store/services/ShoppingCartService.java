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

@Service
public class ShoppingCartService {
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public Long createShoppingCart(ShoppingCartRequest shoppingCartRequest) {
        ShoppingCartMapper mapper = Mappers.getMapper(ShoppingCartMapper.class);
        ShoppingCart persistedShoppingCart = shoppingCartRepository.save(mapper.shoppingCartRequestToShoppingCart(shoppingCartRequest));

        if(persistedShoppingCart == null) {
            throw new UnprocessableEntityException(CREATE_SHOPPING_CART, CREATE_SHOPPING_CART_FAILURE);
        }

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
