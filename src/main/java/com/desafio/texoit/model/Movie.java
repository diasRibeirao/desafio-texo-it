package com.desafio.texoit.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "MOVIES")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "YEAR_MOVIE")
	private Integer year;

	@Column(name = "TITLE")
	private String title;

	@ManyToMany
	@JoinTable(name = "movie_studio", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "studio_id"))
	private Set<Studio> studios;

	@ManyToMany
	@JoinTable(name = "movie_producer", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "producer_id"))
	private Set<Producer> producers;

	@Column(name = "IS_WINNER")
	private Boolean winner;

	public Movie() {

	}

	public Movie(Integer year, String title, Boolean winner) {
		this.year = year;
		this.title = title;
		this.studios = new HashSet<>();
		this.producers = new HashSet<>();
		this.winner = winner;
	}

}
