package com.example.laundry.model;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Report")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Pattern(regexp = "\"\\\\d{3}-\\\\d{2}-\\\\d{4}",
            message = "Invalid report id format")
    private String reportId;

    @Pattern(regexp = "\"\\\\d{3}-\\\\d{2}-\\\\d{4}",
            message = "Invalid order id format")
    private String orderId;

    @Pattern(regexp = "\"\\\\d{3}-\\\\d{2}-\\\\d{4}",
            message = "Invalid customer id format")
    private String customerId;

    @Pattern(regexp = "\"\\\\d{3}-\\\\d{2}-\\\\d{4}",
            message = "Invalid service id format")
    private String serviceId;

    private Date reportDate;

    @Pattern(regexp = "^[A-Za-z '-]{2,50}$",
            message = "Invalid description format")
    private String description;

}