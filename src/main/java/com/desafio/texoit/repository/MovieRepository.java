package com.desafio.texoit.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.texoit.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

	Page<Movie> findAll(Pageable paginacao);
	
	
}
