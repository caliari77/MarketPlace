package com.store.controllers;

import com.store.models.Product;
import com.store.models.requests.ProductRequest;
import com.store.models.responses.ProductResponse;
import com.store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "/product")
    public ResponseEntity createProduct(@RequestBody ProductRequest productRequest) {
        Long id = productService.createProduct(productRequest);
        return new ResponseEntity<>(new ProductResponse(id), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/product/{productId}")
    public ResponseEntity deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PatchMapping(value = "/product")
    public ResponseEntity updateProduct(@RequestBody Product product) {
        Long id = productService.updateProduct(product);
        return new ResponseEntity<>(new ProductResponse(id), HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/product/{productId}")
    public ResponseEntity<Product> findProduct(@PathVariable Long productId) {
        Product product = productService.findProduct(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
