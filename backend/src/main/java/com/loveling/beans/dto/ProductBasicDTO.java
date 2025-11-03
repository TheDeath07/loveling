package com.loveling.beans.dto;

import com.loveling.beans.entity.ProductEntity;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductBasicDTO(long id, String name, BigDecimal price, String collection)
{

    public static ProductBasicDTO from(ProductEntity productEntity) {
        return ProductBasicDTO.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .price(productEntity.getPrice())
                .collection(productEntity.getCollection().getName())
                .build();
    }
}
