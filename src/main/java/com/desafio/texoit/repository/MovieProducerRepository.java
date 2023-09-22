package com.desafio.texoit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.desafio.texoit.model.MovieProducer;
import com.desafio.texoit.model.MovieProducerId;

public interface MovieProducerRepository extends JpaRepository<MovieProducer, MovieProducerId> {

	@Query(value = "SELECT mp from MovieProducer mp JOIN mp.movie m JOIN mp.producer p where m.winner = true order by p.id, m.year")
	List<MovieProducer> findByMovieWinner();

}
