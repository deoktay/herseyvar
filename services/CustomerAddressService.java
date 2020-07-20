package com.spring.herseyvar.services;

import com.spring.herseyvar.entities.CustomerAddressEntity;
import com.spring.herseyvar.entities.CustomerEntity;
import com.spring.herseyvar.entities.UserEntity;
import com.spring.herseyvar.mappers.CustomerAddressMapper;
import com.spring.herseyvar.models.CustomerAddressFormRequest;
import com.spring.herseyvar.models.CustomerAddressFormResponse;
import com.spring.herseyvar.repositories.CustomerAddressRepository;
import com.spring.herseyvar.repositories.CustomerRepository;
import com.spring.herseyvar.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerAddressService {

    public static final Logger log = LoggerFactory.getLogger(CustomerAddressService.class);

    @Resource
    private CustomerAddressRepository customerAddressRepository;

    @Resource
    private CustomerRepository customerRepository;

    @Resource
    private UserRepository userRepository;

    @Resource
    private CustomerAddressMapper customerAddressMapper;

    public CustomerAddressEntity getByCustomerAddressId(Long id) {
        return customerAddressRepository.findById(id).orElse(null);
    }

    public void saveCustomerAddress(CustomerAddressEntity customerAddressEntity) {
        customerAddressRepository.save(customerAddressEntity);
    }

    public List<CustomerAddressEntity> getAllCustomerAddressesByCustomerId(Long customerId) {
        List<CustomerAddressEntity> customerAddressList = customerAddressRepository.findAllByCustomerId(customerId);
        return new ArrayList<>(customerAddressList);
    }

    public CustomerAddressFormResponse getCustomerAddress(CustomerAddressFormRequest request) {

        UserEntity userEntity = userRepository.findByEmail(request.getEmail());

        CustomerEntity customerEntity = customerRepository.findById(userEntity.getCustomer().getId()).orElse(null);

        List<CustomerAddressEntity> customerAddressList = getAllCustomerAddressesByCustomerId(customerEntity.getId());

        customerAddressList = customerAddressMapper.toCustomerAddressForm(request, customerEntity, customerAddressList);

        try {
            customerAddressRepository.findAllByCustomerId(customerEntity.getId());
            return CustomerAddressFormResponse.builder()
                    .isSuccess(true)
                    .build();
        } catch (Exception ex) {
            return CustomerAddressFormResponse.builder()
                    .isSuccess(false)
                    .message("Beklenmeyen bir hata oluştu. Lütfen daha sonra tekrar deneyiniz.")
                    .build();
        }

    }

}
