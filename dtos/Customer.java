package com.spring.herseyvar.dtos;

import com.spring.herseyvar.entities.CustomerEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Customer {

    private Long customerId;
    private Date createdAt;
    private String createdBy;
    private String firstName;
    private String lastName;
    private String telephone;

    public Customer(CustomerEntity entity) {
        this.customerId = entity.getId();
        this.createdAt = entity.getCreatedAt();
        this.createdBy = entity.getCreatedBy();
        this.firstName = entity.getFirstName();
        this.lastName = entity.getLastName();
        this.telephone = entity.getTelephone();
    }
}
