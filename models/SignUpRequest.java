package com.spring.herseyvar.models;

import com.spring.herseyvar.enums.Gender;
import lombok.Data;
import org.thymeleaf.util.DateUtils;

import java.util.Date;

@Data
public class SignUpRequest {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String telephone;
    private Gender gender;
    private boolean isEnabled=true;
    private Date createdAt = DateUtils.createNow().getTime();
    private String createdBy = "Client / User";
}
