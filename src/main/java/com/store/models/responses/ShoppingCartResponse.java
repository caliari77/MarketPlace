package com.store.models.responses;

public class ShoppingCartResponse {
    private Long id;

    public ShoppingCartResponse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
