package com.store.models;

import java.util.UUID;

public class Client {
    private final String id;
    private String name;
    private String documentId;
    private int age;

    public Client(String name, String documentId, int age) {
        id = UUID.randomUUID().toString();
        this.documentId = documentId;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
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
