package com.example.laundry.model;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tblservicetype")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Pattern(regexp = "\"\\\\d{3}-\\\\d{2}-\\\\d{4}",
            message = "Invalid service id format")
    private String serviceTypeId;

    @Pattern(regexp = "^[A-Za-z '-]{2,50}$",
            message = "Invalid name format")
    private String typeName;

    @Pattern(regexp = "^[A-Za-z '-]{2,50}$",
            message = "Invalid description format")
    private String description;

}
