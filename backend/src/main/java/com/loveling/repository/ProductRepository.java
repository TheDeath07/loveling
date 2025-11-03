package com.loveling.repository;

import com.loveling.beans.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<ProductEntity, Long>
{
    @Query("select p from ProductEntity p where p.name like %:name%")
    List<ProductEntity> findByNameIsLike(String name);

    List<ProductEntity> findByNameAndCollectionId(String name, long collectionId);
}
