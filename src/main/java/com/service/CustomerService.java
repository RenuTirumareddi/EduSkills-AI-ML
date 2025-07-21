package com.service;

import com.exception.CustomerNotFoundException;
import com.model.Customer;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    
    // Pre-loaded customer list with 5 Customer objects
    private List<Customer> customerList = new ArrayList<>();
    
    public CustomerService() {
        // Initialize with 5 sample customers
        customerList.add(new Customer("C101", "John Doe", "john.doe@example.com", "9876543210", 
                "New York", LocalDate.of(2023, 1, 15), 150, "Gold"));
        customerList.add(new Customer("C102", "Jane Smith", "jane.smith@example.com", "9876543211", 
                "Los Angeles", LocalDate.of(2023, 2, 20), 75, "Silver"));
        customerList.add(new Customer("C103", "Mike Johnson", "mike.johnson@example.com", "9876543212", 
                "Chicago", LocalDate.of(2023, 3, 10), 200, "Platinum"));
        customerList.add(new Customer("C104", "Sarah Wilson", "sarah.wilson@example.com", "9876543213", 
                "Houston", LocalDate.of(2023, 4, 5), 100, "Gold"));
        customerList.add(new Customer("C105", "David Brown", "david.brown@example.com", "9876543214", 
                "Phoenix", LocalDate.of(2023, 5, 12), 50, "Silver"));
    }
    
    // Register a new customer
    public Customer registerCustomer(Customer customer) {
        customerList.add(customer);
        return customer;
    }
    
    // View customer by ID
    public Customer viewCustomerById(String customerId) {
        return customerList.stream()
                .filter(customer -> customer.getCustomerId().equals(customerId))
                .findFirst()
                .orElseThrow(() -> new CustomerNotFoundException(customerId));
    }
    
    // View customers by tier
    public List<Customer> viewCustomersByTier(String tier) {
        return customerList.stream()
                .filter(customer -> customer.getTier().equalsIgnoreCase(tier))
                .collect(Collectors.toList());
    }
    
    // Increment loyalty points
    public Customer incrementLoyaltyPoints(String customerId, int points) {
        Customer customer = customerList.stream()
                .filter(c -> c.getCustomerId().equals(customerId))
                .findFirst()
                .orElseThrow(() -> new CustomerNotFoundException(customerId));
        
        customer.setLoyaltyPoints(customer.getLoyaltyPoints() + points);
        return customer;
    }
    
    // Delete customer
    public Customer deleteCustomer(String customerId) {
        Customer customer = customerList.stream()
                .filter(c -> c.getCustomerId().equals(customerId))
                .findFirst()
                .orElseThrow(() -> new CustomerNotFoundException(customerId));
        
        customerList.remove(customer);
        return customer;
    }
    
    // Additional utility method to get all customers
    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customerList);
    }
}