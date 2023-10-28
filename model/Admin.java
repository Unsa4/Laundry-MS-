package com.example.laundry.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Admin")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Pattern(regexp = "\"\\\\d{3}-\\\\d{2}-\\\\d{4}",
            message = "Invalid adminId format")
    private String adminId;

    @Pattern(regexp = "[A-Za-z0-9_]{4,20}",
            message = "Invalid username format")
    private String adminUsername;

    private String adminPassword;

    @Pattern(regexp = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b",
            message = "Invalid email format")
    private String adminEmail;

    @Pattern(regexp = "\\d{10}",
            message = "Mobile number must be a 10-digit number")
    private String adminMobile;

    @NotNull(message = "Admin role is required")
    private String adminRole;

    public void setAdminId(Long id) {
        // Custom logic for setting admin ID if needed
    }

    // Getters and Setters
}
