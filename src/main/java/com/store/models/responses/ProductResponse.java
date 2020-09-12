package com.store.models.responses;

import java.io.Serializable;

/**
 * POJO that represents all the info that should be sent by the respective controller {@link com.store.controllers.ProductController}.
 */
public class ProductResponse implements Serializable {

    private Long id;

    public ProductResponse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
