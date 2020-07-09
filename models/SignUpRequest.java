package com.spring.herseyvar.models;

import com.spring.herseyvar.enums.Gender;
import lombok.Data;
import org.thymeleaf.util.DateUtils;

import java.util.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
public class SignUpRequest {

    @Email
    private String email;

    @Size(min = 7, max = 15, message = "Şifreniz 7-15 karakter arasında olmalıdır, harf ve rakam içermelidir.")
    private String password;

    @Size(min = 5, max = 60)
    private String firstName;

    @Size(min = 5, max = 60)
    private String lastName;

    @Size(min = 11, max = 12)
    private String telephone;

    private Gender gender;
    private boolean isEnabled=true;
    private Date createdAt = DateUtils.createNow().getTime();
    private String createdBy = "Client / User";

}
