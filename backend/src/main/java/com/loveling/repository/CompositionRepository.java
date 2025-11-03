package com.loveling.repository;

import com.loveling.beans.entity.CompositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
@Transactional
public interface CompositionRepository extends JpaRepository<CompositionEntity, UUID>
{
}
