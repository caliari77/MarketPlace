package com.store.models.responses;

import java.io.Serializable;

public class ClientResponse implements Serializable {

    private Long id;

    public ClientResponse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
