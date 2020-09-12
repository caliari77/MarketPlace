package com.store.models.requests;

import com.store.models.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
