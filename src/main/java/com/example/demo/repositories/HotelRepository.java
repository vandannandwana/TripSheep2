package com.example.demo.repositories;

import com.example.demo.models.HotelModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface HotelRepository extends MongoRepository<HotelModel,String> {

    public HotelModel findBy_id(String name);

}
