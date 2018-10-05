package com.weatherapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weatherapi.domain.Estate;
import com.weatherapi.repositories.EstateRepository;
import com.weatherapi.services.exceptions.ObjectNotFoundException;

@Service
public class EstateService {
	
	@Autowired
	private EstateRepository repo;
	
	public Estate search(Integer id) {
		Estate obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Object not found, ID: " + id +
					", type: " + Estate.class.getName());
		}
		return obj;
	}

}
