package com.flyobs.billing_service.dto;


import com.flyobs.billing_service.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ProductItemDto{
      private    Long id;
      private    String productId;
      private    double unitPrice;
      private    int quantity ;
      private Product product;
}
