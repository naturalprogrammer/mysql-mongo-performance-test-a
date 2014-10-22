package com.naturalprogrammer.mymongoa.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naturalprogrammer.mymongoa.entities.JpaEntity;
import com.naturalprogrammer.mymongoa.entities.MongoEntity;
import com.naturalprogrammer.mymongoa.repositories.mongo.MongoEntityRepository;

@Service
public class MongoService {

	@Autowired
	private MongoEntityRepository mongoEntityRepository;

	public void createEntities(long count) {
		for (long i = 1; i <= count; i++) {
			MongoEntity mongoEntity = new MongoEntity();
			mongoEntity.setDescr("Mongo Entity " + i + " Created at " + new Date());
			mongoEntityRepository.save(mongoEntity);
		}
	}

	public void retrieveEntities(long count, long step) {
		for (long i = 1; i <= count; i += step) {
			MongoEntity entity = mongoEntityRepository.findOne(i);
			logger.info("Retrieved entity " + entity.getId() + ": " + entity.getDescr());
		}
	}

}
