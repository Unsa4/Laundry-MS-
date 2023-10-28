package com.example.laundry.model;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "item")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Item {

    @Pattern(regexp = "\"\\\\d{3}-\\\\d{2}-\\\\d{4}",
            message = "Invalid userid format")
    private String id;

    @Pattern(regexp = "[A-Za-z0-9_]{4,20}",
            message = "Invalid name format")
    private String name;

    private String category;

    private int quantity;

    @Pattern(regexp = "\"\\\\d{3}-\\\\d{2}-\\\\d{4}",
            message = "Invalid userid format")
    private String orderId;

    public void setItemId(String id) {
    }

    // Getters and Setters
}
