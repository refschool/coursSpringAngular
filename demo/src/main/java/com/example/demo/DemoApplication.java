package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.demo.entities.commercial;
import com.example.demo.entities.prospect;
import com.example.demo.entities.utilisateur;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private final RepositoryRestConfiguration repositoryRestConfiguration;

	DemoApplication(RepositoryRestConfiguration repositoryRestConfiguration) {
		this.repositoryRestConfiguration = repositoryRestConfiguration;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(utilisateur.class, commercial.class, prospect.class);
	}
}
