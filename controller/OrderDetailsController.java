package com.example.laundry.controller;

import com.example.laundry.model.OrderDetails;
import com.example.laundry.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class OrderDetailsController {

    private final OrderDetailsService OrderDetailsService;

    @Autowired
    public OrderDetailsController(OrderDetailsService OrderDetailsService) {
        this.OrderDetailsService = OrderDetailsService;
    }

    @PostMapping("/OrderDetails")
    public ResponseEntity<OrderDetails> createOrderDetails(@Valid @RequestBody OrderDetails OrderDetails) {
        OrderDetails createdOrderDetails = OrderDetailsService.saveOrderDetails(OrderDetails);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrderDetails);
    }

    @GetMapping("/OrderDetails")
    public ResponseEntity<List<OrderDetails>> getAllOrderDetails() {
        List<OrderDetails> OrderDetails = OrderDetailsService.getAllOrderDetails();
        return ResponseEntity.ok(OrderDetails);
    }

    @GetMapping("/OrderDetails/{id}")
    public ResponseEntity<Optional<OrderDetails>> getOrderDetailsById(@PathVariable(value = "id") Long id) {
        Optional<OrderDetails> OrderDetails = OrderDetailsService.getOrderDetailsById(String.valueOf(id));
        if (OrderDetails.isPresent()) {
            return ResponseEntity.ok(OrderDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/OrderDetails/{id}")
    public ResponseEntity<OrderDetails> updateOrderDetails(@PathVariable(value = "id") Long id, @RequestBody OrderDetails OrderDetailsDetails) {
        OrderDetails updatedOrderDetails = OrderDetailsService.updateOrderDetails(String.valueOf(id), OrderDetailsDetails);
        return ResponseEntity.ok(updatedOrderDetails);
    }

    @DeleteMapping("/OrderDetails/{id}")
    public ResponseEntity<Void> deleteOrderDetails(@PathVariable(value = "id") Long id) {
        OrderDetailsService.deleteOrderDetails(String.valueOf(id));
        return ResponseEntity.noContent().build();
    }
}
