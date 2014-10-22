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
	@RequestMapping("/create-mongo-entity/{descr}/{id}")
	public String createMongoEntity(@PathVariable("descr") String descr, @PathVariable("id") long id) {
		
		MongoEntity mongoEntity = new MongoEntity();
		
		mongoEntity.setDescr(descr);
		mongoEntity.setId(id);
		
		mongoEntityRepository.save(mongoEntity);
		
		return Long.toString(mongoEntity.getId());
		
	}
	
	/**
	 * See {@link JpaService#createEntities(long)} for details.
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

	/**
	 * See {@link MongoService#createEntities(long, long)} for details.
	 * 
	 * @param descr
	 * @return
	 */	
	@RequestMapping("/create-mongo-entities/{count}/{startId}")
	public String createMongoEntities(@PathVariable("count") long count, @PathVariable("startId") long startId)
	{
		logger.info("Creating " + count + " Mongo entities starting from " + startId);
		
		mongoService.createEntities(count, startId);
		
		logger.info("Creating Mongo entities complete");

		return "Success";
	}
	
	/**
	 * See {@link JpaService#retrieveEntities(long, long)} for details.
	 * 
	 * @param descr
	 * @return
	 */	
	@RequestMapping("/retrieve-jpa-entities/{count}/{step}")
	public String retrieveJpaEntities(@PathVariable("count") long count, @PathVariable("step") long step) 
	{		
		logger.info("Retrieving " + count + " JPA entities in step " + step);
		jpaService.retrieveEntities(count, step);
		logger.info("Retrieving JPA entities complete");
		
		return "Success";
	}
	
	/**
	 * See {@link MongoService#retrieveEntities(long, long)} for details.
	 * 
	 * @param descr
	 * @return
	 */	
	@RequestMapping("/retrieve-mongo-entities/{count}/{step}")
	public String retrieveMongoEntities(@PathVariable("count") long count, @PathVariable("step") long step) 
	{		
		logger.info("Retrieving " + count + " Mongo entities in step " + step);
		mongoService.retrieveEntities(count, step);
		logger.info("Retrieving Mongo entities complete");
		
		return "Success";
	}	

}
