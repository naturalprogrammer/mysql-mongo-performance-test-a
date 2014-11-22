package com.naturalprogrammer.mymongoa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableMongoRepositories({"com.naturalprogrammer.mymongoa.repositories.mongo"})
@EnableJpaRepositories({"com.naturalprogrammer.mymongoa.repositories.jpa"})
// Neo4j ??
public class Application {

    public static void main(String[] args) {
    	// run Spring 2
    	SpringApplication.run(Application.class, args);
    	
    }
}
