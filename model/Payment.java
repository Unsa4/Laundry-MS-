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
import java.util.Date;

@Document(collection = "tblpayment")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Pattern(regexp = "\"\\\\d{3}-\\\\d{2}-\\\\d{4}",
            message = "Invalid payment id format")
    private String paymentId;

    @Pattern(regexp = "\"\\\\d{3}-\\\\d{2}-\\\\d{4}",
            message = "Invalid order id format")
    private String orderId;

    private BigDecimal amount;

    private BigDecimal paid;

    private BigDecimal balance;

    @Pattern(regexp = "^[A-Za-z '-]{2,50}$",
            message = "Invalid name format")
    private String paidBy;

    private Date paymentDate;

    private Long processedBy;
}
