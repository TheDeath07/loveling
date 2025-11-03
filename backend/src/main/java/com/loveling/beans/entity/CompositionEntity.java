package com.loveling.beans.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Entity(name = "Composition")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompositionEntity implements Serializable
{
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ingredient_id", nullable = false)
    private IngredientEntity ingredient;

    @Column(nullable = false)
    @Positive
    private Double quantity;
}
