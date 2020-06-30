package com.spring.herseyvar.repositories;

import com.spring.herseyvar.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    CustomerEntity findByUserId(Long userId);
}
