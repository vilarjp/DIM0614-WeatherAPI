package com.weatherapi;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.weatherapi.domain.City;
import com.weatherapi.domain.Estate;
import com.weatherapi.domain.Weather;
import com.weatherapi.repositories.CityRepository;
import com.weatherapi.repositories.EstateRepository;

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
	private EstateRepository estateRepository;
	@Autowired
	private CityRepository cityRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(WeatherapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Estate est1 = new Estate(null, "Rio Grande do Norte", "RN");
		Estate est2 = new Estate(null, "São Paulo", "SP");
		
		Weather weat1 = new Weather(null, 1, 2, 3);
		Weather weat2 = new Weather(null, 4, 5, 6);
		Weather weat3 = new Weather(null, 7, 8, 9);
				
		City c1 = new City(null, "Natal", est1, weat1);
		City c2 = new City(null, "São Paulo", est2, weat2);
		City c3 = new City(null, "Campinas", est2, weat3);
				
		est1.getCities().addAll(Arrays.asList(c1));
		est2.getCities().addAll(Arrays.asList(c2, c3));
		
		estateRepository.save(Arrays.asList(est1, est2));
		cityRepository.save(Arrays.asList(c1, c2, c3));
		
	}
	
	
}
