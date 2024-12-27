package com.example.demo.repositories;

import com.example.demo.models.TripPlanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public interface TripPlanRepository extends MongoRepository<TripPlanModel, String> {

}
