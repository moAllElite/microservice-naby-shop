package com.flyobs.inventory_service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


@AllArgsConstructor@NoArgsConstructor
@Getter@Setter@Builder
@Entity
public class Product {
    @Id
    private String id;
    private String name;
    private double price;
    private int quantity;
}
