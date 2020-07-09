package com.spring.herseyvar.mappers;

import com.spring.herseyvar.dtos.Customer;
import com.spring.herseyvar.entities.CustomerEntity;
import com.spring.herseyvar.models.CustomerFormRequest;
import com.spring.herseyvar.models.SignUpRequest;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerEntity toCustomerEntity(SignUpRequest request) {
        CustomerEntity entity = new CustomerEntity();
        entity.setFirstName(request.getFirstName());
        entity.setLastName(request.getLastName());
        entity.setTelephone(request.getTelephone());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setCreatedBy(request.getCreatedBy());
        entity.setGender(request.getGender());
        return entity;
    }

    public CustomerEntity toCustomerForm(CustomerFormRequest customerFormRequest, CustomerEntity customerEntity) {
        customerEntity.setFirstName(customerFormRequest.getFirstName());
        customerEntity.setLastName(customerFormRequest.getLastName());
        customerEntity.setTelephone(customerFormRequest.getTelephone());
        customerEntity.setGender(customerFormRequest.getGender());
        return customerEntity;
    }

    public Customer toCustomerForm(CustomerFormRequest customerFormRequest, Customer customer) {
        customer.setFirstName(customerFormRequest.getFirstName());
        customer.setLastName(customerFormRequest.getLastName());
        customer.setTelephone(customerFormRequest.getTelephone());
        customer.setGender(customerFormRequest.getGender());
        return customer;
    }
}
