package com.store.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * POJO that represents the ShoppingCart model and how It should be mapped into the Database.
 * Please, note that this is a simplistic example and a real system used by enterprises would
 * required a bigger and more detailed representation that better fits into the correspondent business case.
 *
 */
@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ElementCollection
    List<Product> products;

    public ShoppingCart() {
        products = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
