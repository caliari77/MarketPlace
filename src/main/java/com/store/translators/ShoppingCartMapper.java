package com.store.translators;

import com.store.models.ShoppingCart;
import com.store.models.requests.ShoppingCartRequest;
import org.mapstruct.Mapper;

@Mapper
public interface ShoppingCartMapper {

    ShoppingCart shoppingCartRequestToShoppingCart(ShoppingCartRequest productRequest);
}
