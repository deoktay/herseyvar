package com.spring.herseyvar.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignUpResponse {
    private boolean isSuccess;
    private String message;
}
