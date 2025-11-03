package com.loveling.service;

import com.loveling.beans.dto.ProductBasicDTO;
import com.loveling.beans.dto.ProductDTO;
import com.loveling.beans.entity.CollectionEntity;
import com.loveling.beans.entity.ProductEntity;
import com.loveling.beans.exception.ProductNotFoundException;
import com.loveling.repository.CollectionRepository;
import com.loveling.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Year;
import java.util.Currency;
import java.util.List;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class ProductService
{
    private final ProductRepository productRepository;
    private final CollectionRepository collectionRepository;

    @PostConstruct
    public void init() {
        CollectionEntity collection = CollectionEntity.builder()
                .name("first collection init")
                .year(Year.of(2025))
                .build();

        CollectionEntity saveCollection = collectionRepository.save(collection);

        ProductEntity product = ProductEntity.builder()
                .name("first product")
                .price(BigDecimal.valueOf(25.99))
                .currency(Currency.getInstance("EUR"))
                .collection(saveCollection)
                .description("first product description")
                .build();

        productRepository.save(product);
    }


    public ProductService(ProductRepository productRepository, CollectionRepository collectionRepository) {
        this.productRepository = productRepository;
        this.collectionRepository = collectionRepository;
    }

    public ProductDTO findById(long id) {
        return productRepository.findById(id)
                .map(ProductDTO::from)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }

    public List<ProductBasicDTO> findByName(String name) {
        return productRepository.findByNameIsLike(name).stream()
                .map(ProductBasicDTO::from)
                .toList();
    }

    public List<ProductBasicDTO> findByFilter(String name, Long collectionId) {
        return productRepository.findByNameAndCollectionId(name, collectionId).stream()
                .map(ProductBasicDTO::from)
                .toList();
    }

    public List<ProductBasicDTO> findAll() {
        Iterable<ProductEntity> productEntities = productRepository.findAll();


        return StreamSupport.stream(productEntities.spliterator(), false)
                .map(ProductBasicDTO::from)
                .toList();
    }
}
