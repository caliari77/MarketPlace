package com.store.models.responses;

/**
 * POJO that represents all the info that should be sent by the respective controller {@link com.store.controllers.ShoppingCartController}.
 */
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
