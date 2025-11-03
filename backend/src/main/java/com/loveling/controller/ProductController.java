package com.loveling.controller;

import com.loveling.beans.dto.ProductBasicDTO;
import com.loveling.beans.dto.ProductDTO;
import com.loveling.beans.entity.CollectionEntity;
import com.loveling.service.CollectionService;
import com.loveling.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/products")
public class ProductController
{

    private final ProductService productService;
    private final CollectionService collectionService;

    public ProductController(ProductService productService, CollectionService collectionService) {
        this.productService = productService;
        this.collectionService = collectionService;
    }

    @GetMapping("/")
    public Iterable<ProductBasicDTO> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findOne(@PathVariable @Valid Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping("/search/")
    public Iterable<ProductBasicDTO> findByName(@RequestParam(required = false) String name,
                                                @RequestParam(required = false) String collectionName) {
        Optional<CollectionEntity> collection = collectionService.findByName(collectionName);

        if (collection.isPresent()) {
            return productService.findByFilter(name, collection.get().getId());
        }
        return productService.findByName(name);
    }
}
