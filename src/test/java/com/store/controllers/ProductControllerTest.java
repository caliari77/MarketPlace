package com.store.controllers;


import com.store.models.Product;
import com.store.models.ProductTypeEnum;
import com.store.models.requests.ProductRequest;
import com.store.models.responses.ProductResponse;
import com.store.repositories.ProductRepository;
import com.store.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    private ProductRepository repository;
    private ProductController controller;

    @BeforeEach
    public void setUp() {
        ProductService productService = new ProductService(repository);
        controller = new ProductController(productService);
    }

    @Test
    public void whenCreateProductShouldReturnStatusCreated() {
        long expectedIdFromProduct = 1234567;

        Product expectedProduct = new Product();
        expectedProduct.setId(expectedIdFromProduct);
        when(repository.save(any())).thenReturn(expectedProduct);

        ResponseEntity<ProductResponse> result = controller.createProduct(
                new ProductRequest(new BigDecimal(15.00), "pizza", "qwie12387ashjk3", "1938cjoig56098jklg9823", ProductTypeEnum.FOOD));

        assertThat(result.getBody()).isNotNull();
        assertThat(result.getStatusCode())
                .isNotNull()
                .isEqualTo(HttpStatus.CREATED);
        assertThat(result.getBody().getId())
                .isNotNull()
                .isEqualTo(expectedIdFromProduct);
    }

    @Test
    public void whenDeleteProductShouldReturnStatusOk() {

        ResponseEntity result = controller.deleteProduct(1L);

        assertThat(result.getBody()).isNull();
        assertThat(result.getStatusCode())
                .isNotNull()
                .isEqualTo(HttpStatus.OK);
    }

    @Test
    public void whenFindProductShouldReturnStatusOk() {
        long expectedIdFromProduct = 1234567L;

        Product expectedProduct = new Product();
        expectedProduct.setId(expectedIdFromProduct);
        when(repository.findById(eq(expectedIdFromProduct))).thenReturn(Optional.of(expectedProduct));

        ResponseEntity<Product> result = controller.findProduct(expectedIdFromProduct);

        assertThat(result.getBody()).isNotNull();
        assertThat(result.getStatusCode())
                .isNotNull()
                .isEqualTo(HttpStatus.OK);
        assertThat(result.getBody().getId())
                .isNotNull()
                .isEqualTo(expectedIdFromProduct);
    }

    @Test
    public void whenUpdateProductShouldReturnStatusAccepted() {
        long expectedIdFromProduct = 1234567;

        Product Product = new Product();
        Product.setId(expectedIdFromProduct);

        Product expectedProduct = new Product();
        expectedProduct.setId(expectedIdFromProduct);

        when(repository.save(any())).thenReturn(expectedProduct);

        ResponseEntity<ProductResponse> result = controller.updateProduct(Product);

        assertThat(result.getBody()).isNotNull();
        assertThat(result.getStatusCode())
                .isNotNull()
                .isEqualTo(HttpStatus.ACCEPTED);
        assertThat(result.getBody().getId())
                .isNotNull()
                .isEqualTo(expectedIdFromProduct);
    }
}