package com.spring.herseyvar.repositories;

import com.spring.herseyvar.entities.CustomerAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerAddressRepository extends JpaRepository<CustomerAddressEntity, Long> {

    Optional<CustomerAddressEntity> findById(Long id);

    List<CustomerAddressEntity> findAll();

    List<CustomerAddressEntity> findAllByCustomerId(Long customerId);
}
