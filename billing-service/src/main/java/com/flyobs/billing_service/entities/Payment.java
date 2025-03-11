package com.flyobs.billing_service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Entity
public class Payment {
    @Id
    private String id;
    private String itemName;
    private String itemPrice;
    private String env;
    private String refCommand;
    private String commandName;
}
