package com.desafio.texoit.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "STUDIO")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Studio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME", length = 80, unique = true)
	private String name;

	@ManyToMany(mappedBy = "studios")
	private Set<Movie> filmes;

	public Studio() {
		
	}
	
	public Studio(String name) {
		this.name = name;
	}

}
