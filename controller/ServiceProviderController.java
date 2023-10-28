package com.example.laundry.controller;

import com.example.laundry.model.ServiceProvider;
import com.example.laundry.service.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ServiceProviderController {

    private final ServiceProviderService ServiceProviderService;

    @Autowired
    public ServiceProviderController(ServiceProviderService ServiceProviderService) {
        this.ServiceProviderService = ServiceProviderService;
    }

    @PostMapping("/ServiceProviders")
    public ResponseEntity<ServiceProvider> createServiceProvider(@Valid @RequestBody ServiceProvider ServiceProvider) {
        ServiceProvider createdServiceProvider = ServiceProviderService.saveServiceProvider(ServiceProvider);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdServiceProvider);
    }

    @GetMapping("/ServiceProviders")
    public ResponseEntity<List<ServiceProvider>> getAllServiceProviders() {
        List<ServiceProvider> ServiceProviders = ServiceProviderService.getAllServiceProviders();
        return ResponseEntity.ok(ServiceProviders);
    }

    @GetMapping("/ServiceProviders/{id}")
    public ResponseEntity<Optional<ServiceProvider>> getServiceProviderById(@PathVariable(value = "id") Long id) {
        Optional<ServiceProvider> ServiceProvider = ServiceProviderService.getServiceProviderById(String.valueOf(id));
        if (ServiceProvider.isPresent()) {
            return ResponseEntity.ok(ServiceProvider);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/ServiceProviders/{id}")
    public ResponseEntity<ServiceProvider> updateServiceProvider(@PathVariable(value = "id") Long id, @RequestBody ServiceProvider ServiceProviderDetails) {
        ServiceProvider updatedServiceProvider = ServiceProviderService.updateServiceProvider(String.valueOf(id), ServiceProviderDetails);
        return ResponseEntity.ok(updatedServiceProvider);
    }

    @DeleteMapping("/ServiceProviders/{id}")
    public ResponseEntity<Void> deleteServiceProvider(@PathVariable(value = "id") Long id) {
        ServiceProviderService.deleteServiceProvider(String.valueOf(id));
        return ResponseEntity.noContent().build();
    }
}
