package com.spring.herseyvar.models;

import com.spring.herseyvar.enums.Gender;
import lombok.Data;

@Data
public class CustomerFormRequest {

    private String firstName;
    private String lastName;
    private String telephone;
    private String email;
    private Gender gender;

}
