package com.example.laundry.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tblcustomer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Pattern(regexp = "\"\\\\d{3}-\\\\d{2}-\\\\d{4}",
            message = "Invalid userid format")
    private String customerId;

    @Pattern(regexp = "^[A-Za-z '-]{2,50}$",
            message = "Invalid first name format")
    private String customerFirstName;

    @Pattern(regexp = "^[A-Za-z '-]{2,50}$",
            message = "Invalid last name format")
    private String customerLastName;

    @Pattern(regexp = "^[A-Za-z '-]{2,50}$",
            message = "Invalid middlename format")
    private String customerMiddleName;

    @Pattern(regexp = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b",
            message = "Invalid email format")
    private String customerEmail;

    @Pattern(regexp = "\\d{10}",
            message = "Mobile number must be a 10-digit number")
    private String customerMobile;

    private String customerLandline;

    private String profileImage;

    @Pattern(regexp = "[A-Za-z0-9_]{4,20}",
            message = "Invalid username format")
    private String customerUsername;

    private String customerPassword;

    private String accountStatus;

    public void setCustomerId(String id) {
        // Custom logic for setting admin ID if needed
    }
}
