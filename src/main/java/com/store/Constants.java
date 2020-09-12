package com.store;

/**
 * This class contains all the global constants that are used globally in the service.
 *
 */
public class Constants {

    // Listed operations
    public static final String FIND_CLIENT = "Find client";
    public static final String CREATE_CLIENT = "Create client";
    public static final String FIND_PRODUCT = "Find product";
    public static final String CREATE_PRODUCT = "Create product";
    public static final String FIND_SHOPPING_CART = "Find product";
    public static final String CREATE_SHOPPING_CART = "Create product";

    // Failure messages
    public static final String CLIENT_NOT_FOUND = "The requested product was not found on database.";
    public static final String CREATE_CLIENT_FAILURE = "A failure occurred during product creation.";
    public static final String PRODUCT_NOT_FOUND = "The requested product was not found on database.";
    public static final String CREATE_PRODUCT_FAILURE = "A failure occurred during product creation.";
    public static final String SHOPPING_CART_NOT_FOUND = "The requested shopping cart was not found on database.";
    public static final String CREATE_SHOPPING_CART_FAILURE = "A failure occurred during shopping cart creation.";
}
