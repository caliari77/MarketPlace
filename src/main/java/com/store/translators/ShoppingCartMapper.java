package com.store.translators;

import com.store.models.ShoppingCart;
import com.store.models.requests.ShoppingCartRequest;
import org.mapstruct.Mapper;

/**
 * This is a simple translator class that uses the auto generated map struct framework to
 * convert types of POJO's that are related to the {@link ShoppingCart}.
 */
@Mapper
public interface ShoppingCartMapper {

    ShoppingCart shoppingCartRequestToShoppingCart(ShoppingCartRequest productRequest);
}
