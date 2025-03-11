package com.flyobs.billing_service.entities;

import com.flyobs.billing_service.models.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity @Builder
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;
    private double unitPrice;
    private int quantity;
    @ManyToOne
    private Bill bill;
    @Transient private Product product;
}
