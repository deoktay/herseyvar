package com.spring.herseyvar.mappers;

import com.spring.herseyvar.entities.CustomerAddressEntity;
import com.spring.herseyvar.entities.CustomerEntity;
import com.spring.herseyvar.models.CustomerAddressFormRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerAddressMapper {
    public List<CustomerAddressEntity> toCustomerAddressForm(CustomerAddressFormRequest request, CustomerEntity customerEntity, List<CustomerAddressEntity> addressEntities) {
        List<CustomerAddressEntity> addressEntityList = new ArrayList<>(addressEntities);
        CustomerAddressEntity entity = new CustomerAddressEntity();
        entity.setFirstName(request.getFirstName());
        entity.setLastName(request.getLastName());
        entity.setAddress(request.getAddress());
        entity.setCustomer(customerEntity);
        addressEntityList.add(entity);
        return addressEntityList;
    }

}
