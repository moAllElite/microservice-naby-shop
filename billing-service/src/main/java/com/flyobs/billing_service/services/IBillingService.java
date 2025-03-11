package com.flyobs.billing_service.services;

import com.flyobs.billing_service.dto.BillDto;

public interface IBillingService {
    BillDto findById(Long id);


}
