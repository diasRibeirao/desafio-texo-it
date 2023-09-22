package com.desafio.texoit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.texoit.model.Movie;
import com.desafio.texoit.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	public void save(Movie movie) {
		movieRepository.save(movie);
	}

}
