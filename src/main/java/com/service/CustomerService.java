package com.service;

import com.exception.CustomerNotFoundException;
import com.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    
    // In-memory storage for demonstration
    private Map<String, Customer> customerDatabase = new HashMap<>();
    
    // Register a new customer
    public void registerCustomer(Customer customer) {
        customerDatabase.put(customer.getCustomerId(), customer);
    }
    
    // View customer by ID
    public Customer viewCustomerById(String customerId) {
        Customer customer = customerDatabase.get(customerId);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer not found with ID: " + customerId);
        }
        return customer;
    }
    
    // View customers by tier
    public List<Customer> viewCustomersByTier(String tier) {
        return customerDatabase.values().stream()
                .filter(customer -> customer.getTier().equalsIgnoreCase(tier))
                .collect(Collectors.toList());
    }
    
    // Increment loyalty points
    public void incrementLoyaltyPoints(String customerId) {
        Customer customer = customerDatabase.get(customerId);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer not found with ID: " + customerId);
        }
        customer.setLoyaltyPoints(customer.getLoyaltyPoints() + 10); // Increment by 10 points
    }
    
    // Delete customer
    public void deleteCustomer(String customerId) {
        Customer customer = customerDatabase.get(customerId);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer not found with ID: " + customerId);
        }
        customerDatabase.remove(customerId);
    }
    
    // Additional utility method to get all customers (for testing purposes)
    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customerDatabase.values());
    }
}