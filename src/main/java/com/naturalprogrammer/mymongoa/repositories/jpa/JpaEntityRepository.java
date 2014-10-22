package com.naturalprogrammer.mymongoa.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naturalprogrammer.mymongoa.entities.JpaEntity;

public interface JpaEntityRepository extends JpaRepository<JpaEntity, Long> {

}
