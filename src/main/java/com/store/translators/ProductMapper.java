package com.store.translators;

import com.store.models.Product;
import com.store.models.requests.ProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "productRequest.productType", target = "productType")
    })
    Product productRequestToProduct(ProductRequest productRequest);
}
