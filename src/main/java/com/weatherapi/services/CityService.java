package com.weatherapi.services;

import java.util.ArrayList;
import java.util.List;

import org.openweathermap.api.WeatherClientRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.weatherapi.domain.City;
import com.weatherapi.domain.OpenWeatherMapSystem;
import com.weatherapi.repositories.CityRepository;
import com.weatherapi.services.exceptions.DataIntegrityException;
import com.weatherapi.services.exceptions.ObjectNotFoundException;

@Service
public class CityService {
	
	@Autowired
	private CityRepository repo;
	
	public City find(Integer id) {
		City obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("City not found, ID: " + id);
		} else {
			try {
				OpenWeatherMapSystem weather;
				weather = new OpenWeatherMapSystem();
				String city = obj.getName();
				obj.setWeather(weather.getWeather(city));
			} catch (WeatherClientRequestException e) {
				throw new WeatherClientRequestException("No weather information found, ID: " + id);
			}
		}
		return obj;
	}
	
	public City findAtDb(Integer id) {
		City obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("City not found, ID: " + id);
		} else {
			try {
				OpenWeatherMapSystem weather;
				weather = new OpenWeatherMapSystem();
				String city = obj.getName();
				obj.setWeather(weather.getWeather(city));
			} catch (WeatherClientRequestException e) {
				obj = repo.findOne(id);
			}
		}
		return obj;
	}
	
	public List<City> searchAll() {
		List<City> list = new ArrayList<>();
		list = repo.findAll();
		if (list.size() == 0) {
			throw new ObjectNotFoundException("List of cities not found");
		}
		return list;
	}
	
	public City insert(City obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public City update(City obj) {
		City newObj = findAtDb(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		findAtDb(id);
		try {
			repo.delete(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Cannot delete a city that is not empty");
		}
	}
	
	private void updateData(City newObj, City obj) {
		newObj.setName(obj.getName());
		newObj.setWeather(obj.getWeather());
	}

}
