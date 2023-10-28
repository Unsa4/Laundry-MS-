package com.example.laundry.repository;

import com.example.laundry.model.ServiceProvider;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceProviderRepository extends MongoRepository<ServiceProvider, String> {

}
