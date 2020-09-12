package com.store.translators;

import com.store.models.Product;
import com.store.models.requests.ProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * This is a simple translator class that uses the auto generated map struct framework to
 * convert types of POJO's that are related to the {@link Product}.
 */
@Mapper
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "productRequest.productType", target = "productType")
    })
    Product productRequestToProduct(ProductRequest productRequest);
}
