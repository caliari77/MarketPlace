package com.store.models;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {
    private final String id;
    private BigDecimal price;
    private String name;
    private String barCode;
    private String qrCode;
    private final ProductTypeEnum productType;

    public Product(String id, BigDecimal price, String name, String barCode, String qrCode, ProductTypeEnum productType) {
        this.id = UUID.randomUUID().toString();
        this.price = price;
        this.name = name;
        this.barCode = barCode;
        this.qrCode = qrCode;
        this.productType = productType;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public ProductTypeEnum getProductType() {
        return productType;
    }
}
