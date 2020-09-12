package com.store.services;

import com.store.exceptions.UnprocessableEntityException;
import com.store.models.Product;
import com.store.models.ProductTypeEnum;
import com.store.models.requests.ProductRequest;
import com.store.repositories.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository repository;
    private ProductService service;
    private final long expectedIdFromProduct = 1234567;

    @BeforeEach
    public void setUp() {
        service = new ProductService(repository);
    }

    @Test
    public void whenCreateProductShouldReturnId() {

        Product expectedProduct = new Product();
        expectedProduct.setId(expectedIdFromProduct);
        when(repository.save(any())).thenReturn(expectedProduct);

        Long result = service.createProduct(
                new ProductRequest(new BigDecimal(15.00), "pizza", "qwie12387ashjk3", "1938cjoig56098jklg9823", ProductTypeEnum.FOOD));

        assertThat(result)
                .isNotNull()
                .isEqualTo(expectedIdFromProduct);
    }

    @Test
    public void whenDeleteProductShouldReturnOk() {

        Product expectedProduct = new Product();
        expectedProduct.setId(expectedIdFromProduct);

        boolean result = service.deleteProduct(expectedIdFromProduct);

        assertTrue(result);
    }

    @Test
    public void whenUpdateProductShouldReturnId() {
        Product Product = new Product();
        Product.setId(expectedIdFromProduct);
        when(repository.save(any())).thenReturn(Product);

        Long result = service.updateProduct(new Product());

        assertThat(result)
                .isNotNull()
                .isEqualTo(expectedIdFromProduct);
    }

    @Test
    public void whenFindProductShouldReturnProduct() {
        Product Product = new Product();
        Product.setId(expectedIdFromProduct);
        when(repository.findById(any())).thenReturn(Optional.of(Product));

        Product result = service.findProduct(expectedIdFromProduct);

        assertThat(result).isNotNull();
        assertThat(result.getId())
                .isNotNull()
                .isEqualTo(expectedIdFromProduct);
    }

    @Test
    public void whenCreateProductShouldReturnUnprocessableEntityException() {
        when(repository.save(any())).thenReturn(null);

        Assertions.assertThrows(UnprocessableEntityException.class, () -> {
            service.createProduct(
                    new ProductRequest(new BigDecimal(15.00), "pizza", "qwie12387ashjk3", "1938cjoig56098jklg9823", ProductTypeEnum.FOOD));
        });
    }
}