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


@Service
public class ProductService {

    private ProductRepository productRepository;

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

        if(persistedProduct == null) {
            throw new UnprocessableEntityException(CREATE_PRODUCT, CREATE_PRODUCT_FAILURE);
        }

        return persistedProduct.getId();
    }

    public Product findProduct(long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new NotFoundException(FIND_PRODUCT, PRODUCT_NOT_FOUND));
    }
}
