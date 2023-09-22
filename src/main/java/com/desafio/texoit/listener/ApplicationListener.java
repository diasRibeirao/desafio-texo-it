package com.desafio.texoit.listener;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.desafio.texoit.model.Movie;
import com.desafio.texoit.model.Producer;
import com.desafio.texoit.model.Studio;
import com.desafio.texoit.model.dto.CSVRecordDTO;
import com.desafio.texoit.service.MovieService;
import com.desafio.texoit.service.ProducerService;
import com.desafio.texoit.service.StudioService;

@Component
public class ApplicationListener  {
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private StudioService studioService;
	
	@Autowired
	private ProducerService producerService;

	@EventListener(ApplicationReadyEvent.class)
    public void init() {
		readAndInsertMoviesFromCSV();
    }
	
	private void readAndInsertMoviesFromCSV() {
	    try {
	        Resource resource = new ClassPathResource("csv/movielist.csv");

	        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
	            reader.readLine(); 

	            reader.lines()
	                .map(this::readLineCSV)
	                .forEach(this::processCSVRecord);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	private void processCSVRecord(CSVRecordDTO record) {
		Movie movie = new Movie(record.getYear(), record.getTitle(), record.getWinner());

		for (String nameStudio : record.getStudios().split(", and | and |, ")) {
			Studio studio = studioService.findByName(nameStudio.trim());

			if (studio == null) {
				studio = new Studio(nameStudio.trim());
				studioService.save(studio);
			}

			movie.getStudios().add(studio);
		}
		
		for (String nameProducer : record.getProducers().split(", and | and |, ")) {
			Producer producer = producerService.findByName(nameProducer.trim());

			if (producer == null) {
				producer = new Producer(nameProducer.trim());
				producerService.save(producer);
			}

			movie.getProducers().add(producer);
		}

		movieService.save(movie);
	}
	
	private CSVRecordDTO readLineCSV(String line) {
		String[] data = line.split(";");
		CSVRecordDTO record = new CSVRecordDTO();
		record.setYear(Integer.valueOf(data[0]));
		record.setTitle(data[1]);
		record.setStudios(data[2]);
		record.setProducers(data[3]);
		record.setWinner(data.length == 5 && data[4].equalsIgnoreCase("yes"));
		return record;
	}
}
