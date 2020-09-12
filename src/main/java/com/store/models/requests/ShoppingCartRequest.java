package com.store.models.requests;

import com.store.models.Product;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * POJO that represents all the info that should be received by the respective controller {@link com.store.controllers.ShoppingCartController}.
 */
public class ShoppingCartRequest {

    List<Product> products;

    public ShoppingCartRequest() {
        products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
