package com.desafio.texoit.model.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class ProducerMinMaxAwardsDTO {
	private List<ProducerAwardsDTO> min;
	private List<ProducerAwardsDTO> max;

	public ProducerMinMaxAwardsDTO() {
		this.min = new ArrayList<>();
		this.max = new ArrayList<>();
	}
}
