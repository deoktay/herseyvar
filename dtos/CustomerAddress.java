package com.spring.herseyvar.dtos;

import com.spring.herseyvar.entities.CustomerAddressEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerAddress {

    private Long customerAddressId;
    private String firstName;
    private String lastName;
    private String phone;
    private String city;
    private String state;
    private String quarter;
    private String address;
    private String addressTitle;

    public CustomerAddress(CustomerAddressEntity entity) {
        this.customerAddressId = entity.getId();
        this.firstName = entity.getFirstName();
        this.lastName = entity.getLastName();
        this.phone = entity.getPhone();
        this.city = entity.getCity();
        this.state = entity.getState();
        this.quarter = entity.getQuarter();
        this.address = entity.getAddress();
        this.addressTitle = entity.getAddressTitle();
    }
}
