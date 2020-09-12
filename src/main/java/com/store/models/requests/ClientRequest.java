package com.store.models.requests;

import io.swagger.annotations.ApiModelProperty;

/**
 * POJO that represents all the info that should be received by the respective controller {@link com.store.controllers.ClientController}.
 */
public class ClientRequest {
    @ApiModelProperty(value = "name", example = "Daniel")
    private String name;

    @ApiModelProperty(value = "documentId", example = "12345678")
    private String documentId;

    @ApiModelProperty(value = "age", example = "23")
    private int age;

    public ClientRequest(String name, String documentId, int age) {
        this.documentId = documentId;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
