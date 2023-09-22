package com.desafio.texoit.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProducerAwardsDTO {

	public String producer;
	public Integer interval;
	public Integer previousWin;
	public Integer followingWin;

	public ProducerAwardsDTO() {

	}

	public ProducerAwardsDTO(String producer, Integer interval, Integer previousWin, Integer followingWin) {
		this.producer = producer;
		this.interval = interval;
		this.previousWin = previousWin;
		this.followingWin = followingWin;
	}
}
