package com.controller;

import com.exception.CustomerNotFoundException;
import com.model.Customer;
import com.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Register a new customer
    @PostMapping("/registerCustomer")
    public ResponseEntity<Customer> registerCustomer(@Valid @RequestBody Customer customer) {
        Customer registeredCustomer = customerService.registerCustomer(customer);
        return ResponseEntity.status(HttpStatus.OK).body(registeredCustomer);
    }

    // View customer by ID
    @GetMapping("/viewCustomerById/{customerId}")
    public ResponseEntity<Customer> viewCustomerById(@PathVariable String customerId) {
        try {
            Customer customer = customerService.viewCustomerById(customerId);
            return ResponseEntity.status(HttpStatus.OK).body(customer);
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // View customers by tier
    @GetMapping("/viewCustomersByTier/{tier}")
    public ResponseEntity<List<Customer>> viewCustomersByTier(@PathVariable String tier) {
        List<Customer> customers = customerService.viewCustomersByTier(tier);
        return ResponseEntity.status(HttpStatus.OK).body(customers);
    }

    // Increment loyalty points
    @PutMapping("/incrementLoyaltyPoints/{customerId}/{points}")
    public ResponseEntity<Customer> incrementLoyaltyPoints(@PathVariable String customerId, @PathVariable int points) {
        try {
            Customer updatedCustomer = customerService.incrementLoyaltyPoints(customerId, points);
            return ResponseEntity.status(HttpStatus.OK).body(updatedCustomer);
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Delete customer
    @DeleteMapping("/deleteCustomer/{customerId}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable String customerId) {
        try {
            Customer deletedCustomer = customerService.deleteCustomer(customerId);
            return ResponseEntity.status(HttpStatus.OK).body(deletedCustomer);
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}