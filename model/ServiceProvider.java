package com.example.laundry.model;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tblserviceprovider")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Pattern(regexp = "\"\\\\d{3}-\\\\d{2}-\\\\d{4}",
            message = "Invalid userid format")
    private String serviceProviderId;

    @Pattern(regexp = "^[A-Za-z '-]{2,50}$",
            message = "Invalid userid format")
    private String serviceProviderFirstName;

    @Pattern(regexp = "^[A-Za-z '-]{2,50}$",
            message = "Invalid last name format")
    private String serviceProviderLastName;

    @Pattern(regexp = "^[A-Za-z '-]{2,50}$",
            message = "Invalid middle name format")
    private String serviceProviderMiddleName;

    @Pattern(regexp = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b",
            message = "Invalid email format")
    private String serviceProviderEmail;

    @Pattern(regexp = "\\d{10}",
            message = "Mobile number must be a 10-digit number")
    private String serviceProviderMobile;

    @Pattern(regexp = "\\d{10}",
            message = "Mobile number must be a 10-digit number")
    private String serviceProviderLandline;

    private String profileImage;

    @Pattern(regexp = "[A-Za-z0-9_]{4,20}",
            message = "Invalid username format")
    private String serviceProviderUsername;

    private String serviceProviderPassword;

    private String accountStatus;

}
