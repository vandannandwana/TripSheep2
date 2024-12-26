package com.example.demo.repositories;

import com.example.demo.models.HillStationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface HillStationRepository extends MongoRepository<HillStationModel, String> {
	
	

}
