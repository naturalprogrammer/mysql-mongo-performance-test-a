package com.naturalprogrammer.mymongoa.entities;

import javax.persistence.Id;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@TypeAlias("mongo_entity")
public class MongoEntity {
	
	@Id
	private long id;
	
	private String descr;
	
	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
