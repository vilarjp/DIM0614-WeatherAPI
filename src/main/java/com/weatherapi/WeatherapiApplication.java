package com.weatherapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.weatherapi.repositories.CityRepository;

/**
 * @class The WeatherapiApplication class implements an application that creates and fills
 * the database and run the Spring Application
 *
 * @author  João Paulo (vilarjp3@ufrn.edu.br)
 * @author  Luis Eduardo  (cruxiu@ufrn.edu.br)
 * @version 08.10.2018
 */

@SpringBootApplication
public class WeatherapiApplication implements CommandLineRunner {
	
	/**
	 * Invokes and inject the DB repositories
	 */
	@Autowired
	private CityRepository cityRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(WeatherapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		WeatherapiInject weat = new WeatherapiInject();
		weat.inject(cityRepository);
		
	}
	
}
