package com.spring.herseyvar.dtos;

import com.spring.herseyvar.entities.CustomerEntity;
import com.spring.herseyvar.enums.Gender;
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
    private Gender gender;

    public Customer(CustomerEntity entity) {
        this.customerId = entity.getId();
        this.createdAt = entity.getCreatedAt();
        this.createdBy = entity.getCreatedBy();
        this.firstName = entity.getFirstName();
        this.lastName = entity.getLastName();
        this.telephone = entity.getTelephone();
        this.gender = entity.getGender();
    }

}
