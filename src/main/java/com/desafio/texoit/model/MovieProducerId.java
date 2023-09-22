package com.desafio.texoit.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class MovieProducerId {

	private Long idMovie;

	private Long idProducer;

	public MovieProducerId() {
	}
}
