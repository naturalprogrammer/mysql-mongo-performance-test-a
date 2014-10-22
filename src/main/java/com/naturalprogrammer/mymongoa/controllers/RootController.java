package com.naturalprogrammer.mymongoa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naturalprogrammer.mymongoa.entities.JpaEntity;
import com.naturalprogrammer.mymongoa.entities.MongoEntity;
import com.naturalprogrammer.mymongoa.repositories.jpa.JpaEntityRepository;
import com.naturalprogrammer.mymongoa.repositories.mongo.MongoEntityRepository;

@RestController
public class RootController {
	
	@Autowired
	private JpaEntityRepository jpaEntityRepository;

	@Autowired
	private MongoEntityRepository mongoEntityRepository;

	@RequestMapping("/create-jpa-entity/{descr}")
	public String createJpaEntity(@PathVariable("descr") String descr) {
		
		JpaEntity jpaEntity = new JpaEntity();
		
		jpaEntity.setDescr(descr);
		
		jpaEntityRepository.save(jpaEntity);
		
		return Long.toString(jpaEntity.getId());
		
	}
	
	@RequestMapping("/create-mongo-entity/{descr}")
	public String createMongoEntity(@PathVariable("descr") String descr) {
		
		MongoEntity mongoEntity = new MongoEntity();
		
		mongoEntity.setDescr(descr);
		
		mongoEntityRepository.save(mongoEntity);
		
		return mongoEntity.getId();
		
	}
	

}
