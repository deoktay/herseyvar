package com.spring.herseyvar.services;

import com.spring.herseyvar.dtos.Customer;
import com.spring.herseyvar.entities.CustomerEntity;
import com.spring.herseyvar.entities.UserEntity;
import com.spring.herseyvar.mappers.CustomerMapper;
import com.spring.herseyvar.models.CustomerFormRequest;
import com.spring.herseyvar.models.CustomerFormResponse;
import com.spring.herseyvar.repositories.CustomerRepository;
import com.spring.herseyvar.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Objects;

@Service
@Transactional
public class CustomerService {

    public static final Logger log = LoggerFactory.getLogger(CustomerService.class);

    @Resource
    private CustomerRepository customerRepository;

    @Resource
    private UserRepository userRepository;

    @Resource
    private CustomerMapper customerMapper;

    public CustomerEntity getByCustomerId(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public void saveCustomer(CustomerEntity customerEntity) {
        customerRepository.save(customerEntity);
    }

    public CustomerFormResponse getCustomer(CustomerFormRequest customerFormRequest) {

        UserEntity userEntity = userRepository.findByEmail(customerFormRequest.getEmail());

        CustomerEntity customerEntity = getByCustomerId(userEntity.getCustomer().getId());

        Customer customer = new Customer(customerEntity);

        customer = customerMapper.toCustomerForm(customerFormRequest, customer);

        try {
            customerRepository.findById(customer.getCustomerId());
            return CustomerFormResponse.builder()
                    .isSuccess(true)
                    .build();
        } catch (Exception ex) {
            return CustomerFormResponse.builder()
                    .isSuccess(false)
                    .message("Beklenmeyen bir hata oluştu. Lütfen daha sonra tekrar deneyiniz.")
                    .build();
        }

    }

    public CustomerFormResponse updateCustomer(CustomerFormRequest customerFormRequest) {

        UserEntity userEntity = userRepository.findByEmail(customerFormRequest.getEmail());

        CustomerEntity customerEntity = getByCustomerId(userEntity.getCustomer().getId());

        if (Objects.isNull(customerEntity)) {
            log.info("Not save! Check stacktrace!");
            return CustomerFormResponse.builder()
                    .isSuccess(false)
                    .message("Beklenmeyen bir hata oluştu. Lütfen daha sonra tekrar deneyiniz.")
                    .build();
        }

        customerEntity = customerMapper.toCustomerForm(customerFormRequest, customerEntity);

        try {
            customerRepository.save(customerEntity);
            log.info("Customer info saved on data.");
            return CustomerFormResponse.builder()
                    .isSuccess(true)
                    .message("Kaydedildi!")
                    .build();
        } catch (Exception ex) {
            return CustomerFormResponse.builder()
                    .isSuccess(false)
                    .message("Gerekli alanları doldurunuz.")
                    .build();
        }
    }
}
