package com.desafio.texoit.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.texoit.model.MovieProducer;
import com.desafio.texoit.model.Producer;
import com.desafio.texoit.model.dto.ProducerAwardsDTO;
import com.desafio.texoit.model.dto.ProducerMinMaxAwardsDTO;
import com.desafio.texoit.repository.MovieProducerRepository;
import com.desafio.texoit.repository.ProducerRepository;

@Service
public class ProducerService {

	@Autowired
	private ProducerRepository producerRepository;

	@Autowired
	private MovieProducerRepository movieProducerRepository;

	public void save(Producer producer) {
		producerRepository.save(producer);
	}

	public Producer findByName(String name) {
		return producerRepository.findByName(name);
	}

	public ProducerMinMaxAwardsDTO findProducerMinMaxAwards() {
		List<MovieProducer> list = movieProducerRepository.findByMovieWinner();

		ProducerMinMaxAwardsDTO obj = new ProducerMinMaxAwardsDTO();		
		obj.getMin().addAll(findRangeAwards(list, true));
		obj.getMax().addAll(findRangeAwards(list, false));

		return obj;
	}
	
	private List<ProducerAwardsDTO> findRangeAwards(List<MovieProducer> list, boolean findMin) {
	    List<ProducerAwardsDTO> rangeAwardsList = new ArrayList<>();
	    Integer interval = findMin ? Integer.MAX_VALUE : Integer.MIN_VALUE;

	    Map<Producer, Integer> producerLastYearMap = new HashMap<>();

	    for (MovieProducer movieProducer : list) {
	        Producer producer = movieProducer.getProducer();
	        Integer year = movieProducer.getMovie().getYear();

	        if (producerLastYearMap.containsKey(producer)) {
	            Integer lastYear = producerLastYearMap.get(producer);
	            Integer intervalYear = Math.abs(year - lastYear);

	            if ((findMin && intervalYear < interval) || (!findMin && intervalYear > interval)) {
	            	interval = intervalYear;
	                rangeAwardsList.clear(); 
	            }

	            if (intervalYear == interval) {
	                ProducerAwardsDTO extreme = new ProducerAwardsDTO(producer.getName(), intervalYear, lastYear, year);
	                rangeAwardsList.add(extreme);
	            }
	        }

	        producerLastYearMap.put(producer, year);
	    }

	    return rangeAwardsList;
	}

}
