package com.riadh.ecommerce.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;
@Data

@EqualsAndHashCode(callSuper = false)
public class CustomerNotfoundException extends RuntimeException {
    private final String msg;
}

