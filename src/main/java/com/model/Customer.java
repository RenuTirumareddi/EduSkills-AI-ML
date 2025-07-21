package com.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class Customer {
    
    @NotBlank(message = "Customer ID cannot be blank")
    private String customerId;
    
    @NotBlank(message = "Customer name cannot be blank")
    private String customerName;
    
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid")
    private String email;
    
    @NotBlank(message = "Phone number cannot be blank")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number should be 10 digits")
    private String phoneNumber;
    
    @NotNull(message = "Loyalty points cannot be null")
    private Integer loyaltyPoints;
    
    @NotBlank(message = "Tier cannot be blank")
    @Pattern(regexp = "^(Gold|Silver|Bronze)$", message = "Tier must be Gold, Silver, or Bronze")
    private String tier;

    // Default constructor
    public Customer() {
        this.loyaltyPoints = 0;
    }

    // Parameterized constructor
    public Customer(String customerId, String customerName, String email, String phoneNumber, Integer loyaltyPoints, String tier) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.loyaltyPoints = loyaltyPoints != null ? loyaltyPoints : 0;
        this.tier = tier;
    }

    // Getters and Setters
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(Integer loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", loyaltyPoints=" + loyaltyPoints +
                ", tier='" + tier + '\'' +
                '}';
    }
}