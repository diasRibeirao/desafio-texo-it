package com.desafio.texoit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.texoit.model.Studio;

public interface StudioRepository extends JpaRepository<Studio, Long> {

	Studio findByName(String name);

}
