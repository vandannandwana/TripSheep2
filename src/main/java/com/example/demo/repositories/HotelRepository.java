package com.example.demo.repositories;

import com.example.demo.models.HotelModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public interface HotelRepository extends MongoRepository<HotelModel,String> {

    public HotelModel findBy_id(String name);

}
