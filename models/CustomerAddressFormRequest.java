package com.spring.herseyvar.models;

import lombok.Data;

@Data
public class CustomerAddressFormRequest {

    private String firstName;
    private String lastName;
    private String phone;
    private String city;
    private String state;
    private String quarter;
    private String address;
    private String addressTitle;
    private String email;

}
