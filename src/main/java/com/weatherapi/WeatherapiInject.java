package com.weatherapi;

import java.util.ArrayList;
import java.util.List;
import com.weatherapi.domain.City;
import com.weatherapi.domain.Weather;
import com.weatherapi.repositories.CityRepository;

/**
 * @class The WeatherapiApplication class implements an application that creates and fills
 * the database and run the Spring Application
 *
 * @author  João Paulo (vilarjp3@ufrn.edu.br)
 * @author  Luis Eduardo  (cruxiu@ufrn.edu.br)
 * @version 08.10.2018
 */

public class WeatherapiInject{

 public void inject(CityRepository cityRepository){

	 CSVReader csvreader = new CSVReader();
	 String cwd = System.getProperty("user.dir");
	 List<String> list = csvreader.getList(cwd + "/src/main/java/com/weatherapi/cities.csv");
	 List<City> listCities = new ArrayList<City>();
	 
	 for (String cityString : list) {
		 Weather weather = new Weather(null, 1, 2, 3);
		 City city = new City(null, cityString, weather);
		 listCities.add(city);
	 }
	 
	 cityRepository.save(listCities);

 }

}
