package com.store.models.requests;

import com.store.models.ProductTypeEnum;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * POJO that represents all the info that should be received by the respective controller {@link com.store.controllers.ProductController}.
 */
public class ProductRequest {

    @ApiModelProperty(value = "price", example = "15.00")
    private BigDecimal price;

    @ApiModelProperty(value = "name", example = "Pizza now!")
    private String name;

    @ApiModelProperty(value = "barCode", example = "iu123847nmfc90")
    private String barCode;

    @ApiModelProperty(value = "qrCode", example = "jlkfdg9dfgd90889")
    private String qrCode;

    @ApiModelProperty(value = "productType", example = "FOOD")
    private ProductTypeEnum productType;

    public ProductRequest(){}

    public ProductRequest(BigDecimal price, String name, String barCode, String qrCode, ProductTypeEnum productType) {
        this.price = price;
        this.name = name;
        this.barCode = barCode;
        this.qrCode = qrCode;
        this.productType = productType;
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
