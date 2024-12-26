package com.example.demo.repositories;

import com.example.demo.models.VisitingPlaceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VisitingPlaceRepository extends MongoRepository<VisitingPlaceModel, String> {
	
	

}
