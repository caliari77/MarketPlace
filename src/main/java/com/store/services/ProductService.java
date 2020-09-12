package com.store.services;

import com.store.exceptions.NotFoundException;
import com.store.exceptions.UnprocessableEntityException;
import com.store.models.Product;
import com.store.models.requests.ProductRequest;
import com.store.repositories.ProductRepository;
import com.store.translators.ProductMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import static com.store.Constants.*;

/**
 * This is a service that operates all the hypothetical business cases related the {@link com.store.controllers.ProductController}.
 */
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public boolean deleteProduct(Long productId) {
        productRepository.deleteById(productId);
        return true;
    }

    public Long updateProduct(Product product) {
        Product persistedProduct = productRepository.save(product);
        return persistedProduct.getId();
    }

    public Long createProduct(ProductRequest productRequest) {
        ProductMapper mapper = Mappers.getMapper(ProductMapper.class);
        Product persistedProduct = productRepository.save(mapper.productRequestToProduct(productRequest));

        return persistedProduct.getId();
    }

    public Product findProduct(long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new NotFoundException(FIND_PRODUCT, PRODUCT_NOT_FOUND));
    }
}
