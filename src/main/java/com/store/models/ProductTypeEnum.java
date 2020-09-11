package com.store.models;

public enum ProductTypeEnum {
    COSMETICS("1"),
    FOOD("2"),
    PET("3"),
    CLEANING("4"),
    FURNITURE("5");

    ProductTypeEnum(String type) {
        this.type = type;
    }

    private String type;

    public String getType() {
        return type;
    }
}
