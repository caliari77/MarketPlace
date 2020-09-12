package com.store.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;


/**
 * POJO that represents the Product model and how It should be mapped into the Database.
 * Please, note that this is a simplistic example and a real system used by enterprises would
 * required a bigger and more detailed representation that better fits into the correspondent business case.
 *
 */
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private long id;
    private BigDecimal price;
    private String name;
    private String barCode;
    private String qrCode;
    private String productType;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
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

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}
