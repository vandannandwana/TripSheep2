package com.example.demo.repositories;

import com.example.demo.models.TemporaryUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemporaryUserRepository extends MongoRepository<TemporaryUser, String> {

    public TemporaryUser findTemporaryUserBy_id(String email);

}
