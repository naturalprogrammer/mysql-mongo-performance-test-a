package com.naturalprogrammer.mymongoa.repositories.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.naturalprogrammer.mymongoa.entities.MongoEntity;

public interface MongoEntityRepository extends MongoRepository<MongoEntity, String> {

}
