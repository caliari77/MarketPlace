package com.store.models.requests;

/**
 * POJO that represents all the info that should be received by the respective controller {@link com.store.controllers.ClientController}.
 */
public class ClientRequest {

    private String name;
    private String documentId;
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
