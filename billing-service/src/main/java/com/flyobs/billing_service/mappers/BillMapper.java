package com.flyobs.billing_service.mappers;

import com.flyobs.billing_service.dto.BillDto;
import com.flyobs.billing_service.entities.Bill;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BillMapper {

    BillDto toBillDto(Bill bill);
    @Mapping(target = "productItems", source = "productItems")
    @Mapping(target = "customer",source = "customer")
    Bill toBillEntity(BillDto billDto);
}
