package com.flyobs.billing_service.dto;

import com.flyobs.billing_service.models.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@AllArgsConstructor @NoArgsConstructor
@Getter@Setter
public class BillDto{
     private    Long id;
     private    Date billingDate;
     private    Long customerId;
     private    List<ProductItemDto> productItems;
     private    Customer customer;

}
