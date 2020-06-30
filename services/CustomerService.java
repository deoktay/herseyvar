package com.spring.herseyvar.services;

import com.spring.herseyvar.entities.CustomerEntity;
import com.spring.herseyvar.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class CustomerService {

    @Resource
    private CustomerRepository customerRepository;

    public CustomerEntity getByUserId(Long userId) {
        return customerRepository.findByUserId(userId);
    }

    public void saveCustomer(CustomerEntity customerEntity) {
        customerRepository.save(customerEntity);
    }
}
