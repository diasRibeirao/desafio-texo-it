package com.desafio.texoit.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "MOVIE_PRODUCER")
@Getter
@Setter
public class MovieProducer {
	
	@EmbeddedId
	private MovieProducerId id;

	@ManyToOne
	@MapsId("idMovie")
	private Movie movie;
	
	@ManyToOne
	@MapsId("idProducer")
	private Producer producer;

	public MovieProducer() {

	}
}
