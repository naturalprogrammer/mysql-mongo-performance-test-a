package com.naturalprogrammer.mymongoa.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import com.naturalprogrammer.mymongoa.controllers.RootController;
import com.naturalprogrammer.mymongoa.entities.JpaEntity;
import com.naturalprogrammer.mymongoa.repositories.jpa.JpaEntityRepository;

@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class JpaService {

    private static final Logger logger = LoggerFactory.getLogger(JpaService.class);

	@Autowired
	private JpaEntityRepository jpaEntityRepository;

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void createEntities(long count) {
		for (long i = 1; i <= count; i++) {
			JpaEntity jpaEntity = new JpaEntity();
			jpaEntity.setDescr("JPA Entity " + i + " Created at " + new java.util.Date());
			jpaEntityRepository.save(jpaEntity);
		}
	}

	public void retrieveEntities(long count, long step) {
		
		for (long i = 1; i <= count; i += step) {
			JpaEntity entity = jpaEntityRepository.findOne(i);
			logger.info("Retrieved entity " + entity.getId() + ": " + entity.getDescr());
		}
			
	}
	
}
