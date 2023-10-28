package com.example.laundry.controller;

import com.example.laundry.model.Payment;
import com.example.laundry.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PaymentController {

    private final PaymentService PaymentService;

    @Autowired
    public PaymentController(PaymentService PaymentService) {
        this.PaymentService = PaymentService;
    }

    @PostMapping("/Payments")
    public ResponseEntity<Payment> createPayment(@Valid @RequestBody Payment Payment) {
        Payment createdPayment = PaymentService.savePayment(Payment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPayment);
    }

    @GetMapping("/Payments")
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> Payments = PaymentService.getAllPayments();
        return ResponseEntity.ok(Payments);
    }

    @GetMapping("/Payments/{id}")
    public ResponseEntity<Optional<Payment>> getPaymentById(@PathVariable(value = "id") Long id) {
        Optional<Payment> Payment = PaymentService.getPaymentById(String.valueOf(id));
        if (Payment.isPresent()) {
            return ResponseEntity.ok(Payment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/Payments/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable(value = "id") Long id, @RequestBody Payment PaymentDetails) {
        Payment updatedPayment = PaymentService.updatePayment(String.valueOf(id), PaymentDetails);
        return ResponseEntity.ok(updatedPayment);
    }

    @DeleteMapping("/Payments/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable(value = "id") Long id) {
        PaymentService.deletePayment(String.valueOf(id));
        return ResponseEntity.noContent().build();
    }
}
