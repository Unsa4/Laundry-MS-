package com.example.laundry.controller;

import com.example.laundry.model.Services;
import com.example.laundry.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class ServicesController {

    private final ServiceService ServiceService;

    @Autowired
    public ServicesController(ServiceService ServicesService) {
        this.ServiceService = ServicesService;
    }

    @PostMapping("/Services")
    public ResponseEntity<Services> createService(@Valid @RequestBody Services Service) {
        Services createdServices = (Services) ServiceService.saveService(Service);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdServices);
    }

    @GetMapping("/Services")
    public ResponseEntity<List<Services>> getAllServices() {
        List<Services> Services = ServiceService.getAllServices();
        return ResponseEntity.ok(Services);
    }

    @GetMapping("/Services/{id}")
    public ResponseEntity<Optional<Services>> getServicesById(@PathVariable(value = "id") Long id) {
        Optional<Services> Services = ServiceService.getServicesById(String.valueOf(id));
        if (Services.isPresent()) {
            return ResponseEntity.ok(Services);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/Services/{id}")
    public ResponseEntity<Services> updateService(@PathVariable(value = "id") Long id, @RequestBody Services ServiceDetails) {
        Services updatedServices = (Services) ServiceService.updateService(String.valueOf(id), ServiceDetails);
        return ResponseEntity.ok(updatedServices);
    }

    @DeleteMapping("/Services/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable(value = "id") Long id) {
        ServiceService.deleteService(String.valueOf(id));
        return ResponseEntity.noContent().build();
    }
}
