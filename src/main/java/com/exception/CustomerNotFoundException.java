package com.exception;

public class CustomerNotFoundException extends RuntimeException {
    
    public CustomerNotFoundException(String customerId) {
        super("Customer ID " + customerId + " does not exist");
    }
    
    public CustomerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}