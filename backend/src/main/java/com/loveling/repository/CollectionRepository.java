package com.loveling.repository;

import com.loveling.beans.entity.CollectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface CollectionRepository extends JpaRepository<CollectionEntity, Long>
{
    Optional<CollectionEntity> findByName(String name);
}
