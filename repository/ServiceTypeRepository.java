package com.example.laundry.repository;

import com.example.laundry.model.ServiceType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceTypeRepository extends MongoRepository<ServiceType, String> {
}
