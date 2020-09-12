package com.store.models;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * POJO that represents the Client model and how It should be mapped into the Database.
 * Please, note that this is a simplistic example and a real system used by enterprises would
 * required a bigger and more detailed representation that better fits into the correspondent business case.
 *
 */
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private long id;

    @ApiModelProperty(value = "name", example = "Daniel")
    private String name;

    @ApiModelProperty(value = "documentId", example = "12345678")
    private String documentId;

    @ApiModelProperty(value = "age", example = "23")
    private int age;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
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
