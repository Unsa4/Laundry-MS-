package com.example.laundry.controller;

import com.example.laundry.model.Order;
import com.example.laundry.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class OrderController {

    private final OrderService OrderService;

    @Autowired
    public OrderController(OrderService OrderService) {
        this.OrderService = OrderService;
    }

    @PostMapping("/Orders")
    public ResponseEntity<Order> createOrder(@Valid @RequestBody Order Order) {
        Order createdOrder = OrderService.saveOrder(Order);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @GetMapping("/Orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> Orders = OrderService.getAllOrders();
        return ResponseEntity.ok(Orders);
    }

    @GetMapping("/Orders/{id}")
    public ResponseEntity<Optional<Order>> getOrderById(@PathVariable(value = "id") Long id) {
        Optional<Order> Order = OrderService.getOrderById(String.valueOf(id));
        if (Order.isPresent()) {
            return ResponseEntity.ok(Order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/Orders/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable(value = "id") Long id, @RequestBody Order OrderDetails) {
        Order updatedOrder = OrderService.updateOrder(String.valueOf(id), OrderDetails);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/Orders/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable(value = "id") Long id) {
        OrderService.deleteOrder(String.valueOf(id));
        return ResponseEntity.noContent().build();
    }
}
