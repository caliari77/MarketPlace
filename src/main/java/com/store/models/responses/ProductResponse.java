package com.store.models.responses;

import java.io.Serializable;

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
