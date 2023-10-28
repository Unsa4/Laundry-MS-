package com.example.laundry.controller;

import com.example.laundry.model.Customer;
import com.example.laundry.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private final CustomerService CustomerService;

    @Autowired
    public CustomerController(CustomerService CustomerService) {
        this.CustomerService = CustomerService;
    }

    @PostMapping("/Customers")
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer Customer) {
        Customer createdCustomer = CustomerService.saveCustomer(Customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }

    @GetMapping("/Customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> Customers = CustomerService.getAllCustomers();
        return ResponseEntity.ok(Customers);
    }

    @GetMapping("/Customers/{id}")
    public ResponseEntity<Optional<Customer>> getCustomerById(@PathVariable(value = "id") Long id) {
        Optional<Customer> Customer = CustomerService.getCustomerById(String.valueOf(id));
        if (Customer.isPresent()) {
            return ResponseEntity.ok(Customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/Customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Long id, @RequestBody Customer CustomerDetails) {
        Customer updatedCustomer = CustomerService.updateCustomer(String.valueOf(id), CustomerDetails);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/Customers/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable(value = "id") Long id) {
        CustomerService.deleteCustomer(String.valueOf(id));
        return ResponseEntity.noContent().build();
    }
}
