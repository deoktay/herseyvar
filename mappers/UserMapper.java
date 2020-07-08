package com.spring.herseyvar.mappers;

import com.spring.herseyvar.entities.CustomerEntity;
import com.spring.herseyvar.entities.UserEntity;
import com.spring.herseyvar.models.SignUpRequest;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserEntity toUserEntity(SignUpRequest request, CustomerEntity customerEntity) {
        UserEntity entity = new UserEntity();
        entity.setEmail(request.getEmail());
        entity.setPassword(request.getPassword());
        entity.setEnabled(request.isEnabled());
        entity.setCustomer(customerEntity);
        return entity;
    }
}
