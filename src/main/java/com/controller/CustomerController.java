package com.controller;

import com.exception.CustomerNotFoundException;
import com.model.Customer;
import com.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Register a new customer
    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer(@Valid @RequestBody Customer customer) {
        customerService.registerCustomer(customer);
        return ResponseEntity.ok("Customer registered successfully");
    }

    // View customer by ID
    @GetMapping("/view/{id}")
    public ResponseEntity<Customer> viewCustomerById(@PathVariable("id") String customerId) {
        try {
            Customer customer = customerService.viewCustomerById(customerId);
            return ResponseEntity.ok(customer);
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // View customers by tier
    @GetMapping("/viewByTier/{tier}")
    public ResponseEntity<List<Customer>> viewCustomersByTier(@PathVariable("tier") String tier) {
        List<Customer> customers = customerService.viewCustomersByTier(tier);
        return ResponseEntity.ok(customers);
    }

    // Increment loyalty points
    @PutMapping("/incrementPoints/{id}")
    public ResponseEntity<String> incrementLoyaltyPoints(@PathVariable("id") String customerId) {
        try {
            customerService.incrementLoyaltyPoints(customerId);
            return ResponseEntity.ok("Loyalty points incremented");
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete customer
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") String customerId) {
        try {
            customerService.deleteCustomer(customerId);
            return ResponseEntity.ok("Customer deleted successfully");
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}