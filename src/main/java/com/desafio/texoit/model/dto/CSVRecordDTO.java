package com.desafio.texoit.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CSVRecordDTO {
	private Integer year;
	private String title;
	private String studios;
	private String producers;
	private Boolean winner;
}
