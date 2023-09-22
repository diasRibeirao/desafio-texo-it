package com.desafio.texoit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.texoit.model.Studio;
import com.desafio.texoit.repository.StudioRepository;

@Service
public class StudioService {

	@Autowired
	private StudioRepository studioRepository;

	public void save(Studio studio) {
		studioRepository.save(studio);
	}

	public Studio findByName(String name) {
		return studioRepository.findByName(name);
	}

}
