package com.weatherapi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weatherapi.domain.City;
import com.weatherapi.repositories.CityRepository;
import com.weatherapi.services.exceptions.ObjectNotFoundException;

@Service
public class CityService {
	
	@Autowired
	private CityRepository repo;
	
	public City search(Integer id) {
		City obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Object not found, ID: " + id +
					", type: " + City.class.getName());
		}
		return obj;
	}
	
	public List<City> searchAll() {
		List<City> list = new ArrayList<>();
		list = repo.findAll();
		if (list == null) {
			throw new ObjectNotFoundException("List of objects not found, "
					+ "type: " + City.class.getName());
		}
		return list;
	}

}
