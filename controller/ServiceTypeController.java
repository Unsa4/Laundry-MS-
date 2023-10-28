package com.example.laundry.controller;

import com.example.laundry.model.ServiceType;
import com.example.laundry.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ServiceTypeController {

    private final ServiceTypeService ServiceTypeService;

    @Autowired
    public ServiceTypeController(ServiceTypeService ServiceTypeService) {
        this.ServiceTypeService = ServiceTypeService;
    }

    @PostMapping("/ServiceTypes")
    public ResponseEntity<ServiceType> createServiceType(@Valid @RequestBody ServiceType ServiceType) {
        ServiceType createdServiceType = ServiceTypeService.saveServiceType(ServiceType);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdServiceType);
    }

    @GetMapping("/ServiceTypes")
    public ResponseEntity<List<ServiceType>> getAllServiceTypes() {
        List<ServiceType> ServiceTypes = ServiceTypeService.getAllServiceTypes();
        return ResponseEntity.ok(ServiceTypes);
    }

    @GetMapping("/ServiceTypes/{id}")
    public ResponseEntity<Optional<ServiceType>> getServiceTypeById(@PathVariable(value = "id") Long id) {
        Optional<ServiceType> ServiceType = ServiceTypeService.getServiceTypeById(String.valueOf(id));
        if (ServiceType.isPresent()) {
            return ResponseEntity.ok(ServiceType);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/ServiceTypes/{id}")
    public ResponseEntity<ServiceType> updateServiceType(@PathVariable(value = "id") Long id, @RequestBody ServiceType ServiceTypeDetails) {
        ServiceType updatedServiceType = ServiceTypeService.updateServiceType(String.valueOf(id), ServiceTypeDetails);
        return ResponseEntity.ok(updatedServiceType);
    }

    @DeleteMapping("/ServiceTypes/{id}")
    public ResponseEntity<Void> deleteServiceType(@PathVariable(value = "id") Long id) {
        ServiceTypeService.deleteServiceType(String.valueOf(id));
        return ResponseEntity.noContent().build();
    }
}
