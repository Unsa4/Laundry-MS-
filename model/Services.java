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

@Document(collection = "tblservice")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Pattern(regexp = "\"\\\\d{3}-\\\\d{2}-\\\\d{4}",
            message = "Invalid service id format")
    private String serviceId;

    @Pattern(regexp = "^[A-Za-z '-]{2,50}$",
            message = "Invalid name format")
    private String serviceName;

    private BigDecimal price;

    @Pattern(regexp = "\"\\\\d{3}-\\\\d{2}-\\\\d{4}",
            message = "Invalid userid format")
    private String serviceTypeId;

    private String serviceImage;

    private String serviceStatus;

    @Pattern(regexp = "\"\\\\d{3}-\\\\d{2}-\\\\d{4}",
            message = "Invalid userid format")
    private String serviceProviderId;

}
