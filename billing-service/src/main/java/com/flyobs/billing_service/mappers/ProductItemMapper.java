package com.flyobs.billing_service.mappers;

import com.flyobs.billing_service.dto.ProductItemDto;
import com.flyobs.billing_service.entities.ProductItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProductItemMapper {
    ProductItem toEntity(ProductItemDto productItemDto);
    @Mapping(target = "productId", source = "product.id") // Map productId from product
    ProductItemDto toProductItemDto(ProductItem productItem);

}
