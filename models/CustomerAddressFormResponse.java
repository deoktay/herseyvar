package com.spring.herseyvar.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerAddressFormResponse {
    private boolean isSuccess;
    private String message;
}
