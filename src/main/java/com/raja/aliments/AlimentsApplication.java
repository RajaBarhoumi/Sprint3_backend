package com.raja.aliments;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.raja.aliments.entities.Aliment;
import com.raja.aliments.entities.Famille;

@SpringBootApplication
public class AlimentsApplication implements CommandLineRunner {
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(AlimentsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Aliment.class, Famille.class);
	}
/*
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	*/

}
