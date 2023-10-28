package com.example.laundry.repository;

import com.example.laundry.model.OrderDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends MongoRepository<OrderDetails, String> {

}
