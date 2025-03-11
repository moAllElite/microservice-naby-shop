package com.flyobs.billing_service.services;

import com.flyobs.billing_service.dto.BillDto;
import com.flyobs.billing_service.entities.Bill;
import com.flyobs.billing_service.entities.ProductItem;
import com.flyobs.billing_service.feign.CustomerRestClient;
import com.flyobs.billing_service.feign.ProductRestClient;
import com.flyobs.billing_service.mappers.BillMapper;
import com.flyobs.billing_service.mappers.ProductItemMapper;
import com.flyobs.billing_service.repositories.BillRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BillingService implements IBillingService{
    private final BillRepository billRepository;
    private final ProductItemMapper productItemMapper;
    private final CustomerRestClient customerRestClient;
    private final ProductRestClient productRestClient;
    private final BillMapper billMapper;
    @Override
    public BillDto findById(Long id) {
        Bill bill = billRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("No bill were found with provided id:"+id)
        );
        bill.setCustomer(customerRestClient.findCustomerById(bill.getCustomerId()));

        List<ProductItem> productItems = bill.getProductItems() ;
        productItems.forEach(
                item -> item.setProduct(
                            productRestClient.getProductById( item.getProductId())
                )
        );
        return billMapper.toBillDto(bill);
    }

}
