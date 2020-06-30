package com.spring.herseyvar.dtos;

import com.spring.herseyvar.entities.UserEntity;
import com.spring.herseyvar.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

    private Long userId;
    private String email;
    private String password;
    private Gender gender;
    private boolean isEnabled=true;

    public User(UserEntity entity) {
        this.userId = entity.getId();
        this.email = entity.getEmail();
        this.password = entity.getPassword();
        this.gender = entity.getGender();
        this.isEnabled = entity.isEnabled();
    }
}
