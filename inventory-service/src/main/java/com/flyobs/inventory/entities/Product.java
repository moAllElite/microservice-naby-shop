package com.flyobs.inventory.entities;

import jakarta.persistence.Entity;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    private String id;
    private String name;
    private double price;
    private int quantity;
}
