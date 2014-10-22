package com.naturalprogrammer.mymongoa.services;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naturalprogrammer.mymongoa.entities.MongoEntity;
import com.naturalprogrammer.mymongoa.repositories.mongo.MongoEntityRepository;

@Service
public class MongoService {

    private static final Logger logger = LoggerFactory.getLogger(MongoService.class);

    @Autowired
	private MongoEntityRepository mongoEntityRepository;

	/**
	 * Create "count" Mongo entities starting with id "startId."
	 * Do this first for creating, say, 110,000 entities.
	 *
	 * @param count
	 * @param startId
	 */
    public void createEntities(long count, long startId) {

		for (long i = 0; i < count; i++) {

			long id = startId + i;
			
			MongoEntity mongoEntity = new MongoEntity();			
			mongoEntity.setDescr("Mongo Entity " + id + " Created at " + new Date());
			mongoEntity.setId(id);
			mongoEntityRepository.save(mongoEntity);
		}
	}

	/**
	 * Retrieve "count" entities starting from 1 in step "step."
	 * Do this to retrieve, say 200 records in step, say 500
	 *
	 * @param count
	 * @param step
	 */
    public void retrieveEntities(long count, long step) {

    	long nextId = 1;

    	for (long i = 0; i < count; i++) {
    		
			MongoEntity entity = mongoEntityRepository.findOne(nextId);
			logger.info("Retrieved entity " + entity.getId() + ": " + entity.getDescr());
			
			nextId += step;
		}
	}

}
