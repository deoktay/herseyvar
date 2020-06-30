package com.spring.herseyvar.services;

import com.spring.herseyvar.mappers.CustomerMapper;
import com.spring.herseyvar.mappers.UserMapper;
import com.spring.herseyvar.auth.UserAuthority;
import com.spring.herseyvar.entities.CustomerEntity;
import com.spring.herseyvar.entities.UserEntity;
import com.spring.herseyvar.models.SignUpRequest;
import com.spring.herseyvar.models.SignUpResponse;
import com.spring.herseyvar.repositories.CustomerRepository;
import com.spring.herseyvar.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@EnableGlobalAuthentication
public class UserService implements UserDetailsService {

    public static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Resource
    private UserRepository userRepository;

    @Resource
    private CustomerRepository customerRepository;

    @Resource
    private UserMapper userMapper;

    @Resource
    private CustomerMapper customerMapper;

    @Transactional
    public UserEntity getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Transactional
    public UserEntity getUserById(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(null);
    }

    @Transactional
    public List<UserEntity> getUserAll() {
        List<UserEntity> users = userRepository.findAll();
        return new ArrayList<>(users);
    }

    @Transactional
    public void saveUser(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    @Transactional
    public SignUpResponse signUp(SignUpRequest signUpRequest) {
        UserEntity userEntity = getUserByEmail(signUpRequest.getEmail());
        if (Objects.nonNull(userEntity)) {
            return SignUpResponse.builder()
                    .isSuccess(false)
                    .message("Bu email adresi zaten kayıtlıdır")
                    .build();
        }

        CustomerEntity customerEntity = customerMapper.toCustomerEntity(signUpRequest);
        userEntity = userMapper.toUserEntity(signUpRequest, customerEntity);

        try {
            customerRepository.save(customerEntity);
            userRepository.save(userEntity);

            return SignUpResponse.builder()
                    .isSuccess(true)
                    .build();

        } catch (Exception ex) {
            return SignUpResponse.builder()
                    .isSuccess(false)
                    .message("Kayıt işlemi yapılırken bir hata oluştu.")
                    .build();
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserEntity user = userRepository.findByEmail(email);

        if (user == null) {
            log.info("User not found because not sign up.");
            throw new UsernameNotFoundException(email);
        }

        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setUserRoles(user.getUserRoles());
        user.setCustomer(new CustomerEntity());
        log.info("User infos is found on database.");

        return new UserAuthority(user);
    }

}
