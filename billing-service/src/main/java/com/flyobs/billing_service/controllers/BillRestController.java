package com.flyobs.billing_service.controllers;

import com.flyobs.billing_service.dto.BillDto;
import com.flyobs.billing_service.services.IBillingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("/bills")
@RestController
public class BillRestController {
    private final IBillingService billingService;
    @GetMapping("/{billId}")
    public ResponseEntity<BillDto> getBill(@PathVariable Long billId){
        return  ResponseEntity.ok(billingService.findById(billId));
    }
}
