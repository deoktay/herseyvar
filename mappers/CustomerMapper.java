package com.spring.herseyvar.mappers;

import com.spring.herseyvar.entities.CustomerEntity;
import com.spring.herseyvar.models.SignUpRequest;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public CustomerEntity toCustomerEntity(SignUpRequest request){
        CustomerEntity entity = new CustomerEntity();
        entity.setFirstName(request.getFirstName());
        entity.setLastName(request.getLastName());
        entity.setTelephone(request.getTelephone());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setCreatedBy(request.getCreatedBy());
        return entity;
    }
}
