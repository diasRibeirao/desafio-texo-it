package com.desafio.texoit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.texoit.model.dto.ProducerMinMaxAwardsDTO;
import com.desafio.texoit.service.ProducerService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/producers")
@Tag(name = "Producers")
public class ProducerController {

	@Autowired
	private ProducerService service;

	@GetMapping(value = "/interval-awards")
	public ResponseEntity<ProducerMinMaxAwardsDTO> findProducersIntervalAwards() {
		ProducerMinMaxAwardsDTO obj = service.findProducerMinMaxAwards();

		if (obj.getMax().isEmpty() && obj.getMin().isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok().body(obj);
	}
}
