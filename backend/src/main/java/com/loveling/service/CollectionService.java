package com.loveling.service;

import com.loveling.beans.entity.CollectionEntity;
import com.loveling.repository.CollectionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class CollectionService
{
    private final CollectionRepository collectionRepository;

    public CollectionService(CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
    }

    public Optional<CollectionEntity> findByName(String name) {
        return collectionRepository.findByName(name);
    }
}
