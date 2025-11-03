package com.loveling.beans.dto;

import com.loveling.beans.entity.CompositionEntity;
import com.loveling.beans.entity.ProductEntity;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

@Builder
public record ProductDTO(long id,
                         String name,
                         String description,
                         BigDecimal price,
                         Currency currency,
                         String collectionName,
                         List<CompositionEntity> composition)
{
    public static ProductDTO from(ProductEntity productEntity) {
        return ProductDTO.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .description(productEntity.getDescription())
                .price(productEntity.getPrice())
                .currency(productEntity.getCurrency())
                .collectionName(productEntity.getCollection().getName())
                .composition(productEntity.getCompositions())
                .build();
    }
}
