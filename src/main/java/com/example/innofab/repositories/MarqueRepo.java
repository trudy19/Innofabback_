package com.example.innofab.repositories;

import com.example.innofab.models.Marque;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MarqueRepo extends MongoRepository<Marque,String> {
    Optional<Marque> findByCode(String token);
    boolean existsByCode(String email);

}
