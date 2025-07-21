package com.model;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class Customer {
    
    @NotBlank(message = "Provide value for customer id")
    private String customerId;
    
    @NotBlank(message = "Provide value for name")
    private String name;
    
    @NotBlank(message = "Invalid email format")
    @Email(message = "Invalid email format")
    private String email;
    
    @NotBlank(message = "Mobile Number should be a 10-digit number")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile Number should be a 10-digit number")
    private String mobileNumber;
    
    @NotBlank(message = "Provide value for city")
    private String city;
    
    @PastOrPresent(message = "Registration date cannot be in the future")
    private LocalDate registrationDate;
    
    @Min(value = 0, message = "Loyalty points should be greater than or equal to zero")
    private Integer loyaltyPoints;
    
    @NotBlank(message = "Tier must be Gold, Silver, or Platinum")
    @Pattern(regexp = "^(Gold|Silver|Platinum)$", message = "Tier must be Gold, Silver, or Platinum")
    private String tier;

    // Default constructor
    public Customer() {
        this.loyaltyPoints = 0;
        this.registrationDate = LocalDate.now();
    }

    // Parameterized constructor
    public Customer(String customerId, String name, String email, String mobileNumber, String city, 
                   LocalDate registrationDate, Integer loyaltyPoints, String tier) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.city = city;
        this.registrationDate = registrationDate != null ? registrationDate : LocalDate.now();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
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
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", city='" + city + '\'' +
                ", registrationDate=" + registrationDate +
                ", loyaltyPoints=" + loyaltyPoints +
                ", tier='" + tier + '\'' +
                '}';
    }
}