package com.loveling.beans.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Collection")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CollectionEntity implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Year year;

    @OneToMany(mappedBy = "collection", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<ProductEntity> products = new ArrayList<>();
}
