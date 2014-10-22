package com.naturalprogrammer.mymongoa.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naturalprogrammer.mymongoa.entities.JpaEntity;
import com.naturalprogrammer.mymongoa.entities.MongoEntity;
import com.naturalprogrammer.mymongoa.repositories.jpa.JpaEntityRepository;
import com.naturalprogrammer.mymongoa.repositories.mongo.MongoEntityRepository;
import com.naturalprogrammer.mymongoa.services.JpaService;
import com.naturalprogrammer.mymongoa.services.MongoService;

@RestController
public class RootController {
	
    private static final Logger logger = LoggerFactory.getLogger(RootController.class);
	
	@Autowired
	private JpaEntityRepository jpaEntityRepository;

	@Autowired
	private MongoEntityRepository mongoEntityRepository;
	
	@Autowired
	private JpaService jpaService;
	
	@Autowired
	private MongoService mongoService;
	
	/**
	 * Creates a new jpa entity. Used for testing that the environment is working ok
	 * 
	 * @param descr
	 * @return
	 */
	@RequestMapping("/create-jpa-entity/{descr}")
	public String createJpaEntity(@PathVariable("descr") String descr) {
		
		JpaEntity jpaEntity = new JpaEntity();
		
		jpaEntity.setDescr(descr);
		
		jpaEntityRepository.save(jpaEntity);
		
		return Long.toString(jpaEntity.getId());
		
	}
	
	/**
	 * Creates a new Mongo entity. Used for testing whether the environment is working ok
	 * 
	 * @param descr
	 * @return
	 */
	@RequestMapping("/create-mongo-entity/{descr}")
	public String createMongoEntity(@PathVariable("descr") String descr) {
		
		MongoEntity mongoEntity = new MongoEntity();
		
		mongoEntity.setDescr(descr);
		
		mongoEntityRepository.save(mongoEntity);
		
		return mongoEntity.getId();
		
	}
	
	/**
	 * Creates a new JPA entity. Used for testing whether the environment is working ok
	 * 
	 * @param descr
	 * @return
	 */
	@RequestMapping("/create-jpa-entities/{count}")
	public String createJpaEntities(@PathVariable("count") long count)	
	{
		
		logger.info("Creating " + count + " JPA entities");
		
		jpaService.createEntities(count);
		
		logger.info("Creating JPA entities complete");
		
		return "Success";
	}

	@RequestMapping("/create-mongo-entities/{count}")
	public String createMongoEntities(@PathVariable("count") long count)
	{
		logger.info("Creating " + count + " Mongo entities");
		
		mongoService.createEntities(count);
		
		logger.info("Creating Mongo entities complete");

		return "Success";
	}
	
	@RequestMapping("/retrive-jpa-entities/{count}/{step}")
	public String retrieveJpaEntities(long count, long step) 
	{		
		logger.info("Retrieving " + count + " JPA entities in step " + step);
		jpaService.retrieveEntities(count, step);
		logger.info("Retrieving JPA entities complete");
		
		return "Success";
	}
	
	@RequestMapping("/retrive-mongo-entities/{count}/{step}")
	public String retrieveMongoEntities(long count, long step) 
	{		
		logger.info("Retrieving " + count + " Mongo entities in step " + step);
		mongoService.retrieveEntities(count, step);
		logger.info("Retrieving Mongo entities complete");
		
		return "Success";
	}	

}
