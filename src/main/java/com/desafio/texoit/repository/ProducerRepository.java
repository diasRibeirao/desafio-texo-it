package com.desafio.texoit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.texoit.model.Producer;

public interface ProducerRepository extends JpaRepository<Producer, Long> {

	Producer findByName(String name);
}
