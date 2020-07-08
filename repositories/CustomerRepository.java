package com.spring.herseyvar.repositories;

import com.spring.herseyvar.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    Optional<CustomerEntity> findById(Long customerId);

    List<CustomerEntity> findAll();
}
