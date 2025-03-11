package com.flyobs.billing_service.repositories;

import com.flyobs.billing_service.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@EnableJpaRepositories
@RepositoryRestResource
public interface BillRepository extends JpaRepository<Bill,Long> {
}
