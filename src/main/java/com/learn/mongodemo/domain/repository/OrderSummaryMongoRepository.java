package com.learn.mongodemo.domain.repository;

import com.learn.mongodemo.domain.entity.OrderSummaryMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderSummaryMongoRepository extends MongoRepository<OrderSummaryMongo, String> {

}
