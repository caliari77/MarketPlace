package com.store.models;

/**
 * Simple Enum that represents the all the categories that this service supports.
 * Please, note that this is a simplistic example and a real system used by enterprises would
 * required a bigger and more detailed representation that better fits into the correspondent business case.
 *
 */
public enum ProductTypeEnum {
    COSMETICS("1"),
    FOOD("2"),
    PET("3"),
    CLEANING("4"),
    FURNITURE("5");

    ProductTypeEnum(String type) {
        this.type = type;
    }

    private final String type;

    public String getType() {
        return type;
    }
}
