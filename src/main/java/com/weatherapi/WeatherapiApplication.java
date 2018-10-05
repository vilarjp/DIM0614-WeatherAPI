package com.weatherapi;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.weatherapi.domain.City;
import com.weatherapi.domain.Estate;
import com.weatherapi.repositories.CityRepository;
import com.weatherapi.repositories.EstateRepository;

@SpringBootApplication
public class WeatherapiApplication implements CommandLineRunner {

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
		
		City c1 = new City(null, "Natal", est1);
		City c2 = new City(null, "São Paulo", est2);
		City c3 = new City(null, "Campinas", est2);
		
		est1.getCities().addAll(Arrays.asList(c1));
		est1.getCities().addAll(Arrays.asList(c2, c3));
		
		estateRepository.save(Arrays.asList(est1, est2));
		cityRepository.save(Arrays.asList(c1, c2, c3));
		
	}
	
	
}
