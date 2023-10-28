package com.example.laundry.model;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "tblportfolio")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Pattern(regexp = "\"\\\\d{3}-\\\\d{2}-\\\\d{4}",
            message = "Invalid userid format")
    private String id;

    @Pattern(regexp = "\"\\\\d{3}-\\\\d{2}-\\\\d{4}",
            message = "Invalid service provider id format")
    private String serviceProviderId;

    @Pattern(regexp = "^[A-Za-z '-]{2,50}$",
            message = "Invalid service type format")
    private String serviceType;

    @Pattern(regexp = "^[A-Za-z '-]{2,50}$",
            message = "Invalid description format")
    private String description;

    private BigDecimal pricing;

    private int turnaroundTime;

    @Pattern(regexp = "^[A-Za-z '-]{2,50}$",
            message = "Invalid special features format")
    private String specialFeatures;

    private String beforeImage;

    private String afterImage;

    public void setPortfolioId(String id) {
    }
}
