package com.example.demo.repositories;

import com.example.demo.models.TripPackageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripPackageRepository extends MongoRepository<TripPackageModel, String> {
	
	
	
}
