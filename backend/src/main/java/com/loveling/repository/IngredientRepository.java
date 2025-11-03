package com.loveling.repository;

import com.loveling.beans.entity.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IngredientRepository extends JpaRepository<IngredientEntity, Long>
{
}
