package com.desafio.texoit.desafiotexoit;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.desafio.texoit.controller.ProducerController;

@SpringBootTest
@AutoConfigureMockMvc
public class ProducerControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ProducerController producerController;

	@Autowired
	protected WebApplicationContext webApplicationContext;

	@BeforeEach
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.producerController).build();
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void findProducersIntervalAwardsTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/producers/interval-awards").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("$.min.*.producer", hasItem(is("Joel Silver"))))
				.andExpect(jsonPath("$.max.*.producer", hasItem(is("Matthew Vaughn"))));

	}
}
