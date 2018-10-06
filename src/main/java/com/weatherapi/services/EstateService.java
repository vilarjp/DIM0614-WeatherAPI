package com.weatherapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.weatherapi.domain.Estate;
import com.weatherapi.repositories.EstateRepository;
import com.weatherapi.services.exceptions.DataIntegrityException;
import com.weatherapi.services.exceptions.ObjectNotFoundException;

@Service
public class EstateService {
	
	@Autowired
	private EstateRepository repo;
	
	public Estate find(Integer id) {
		Estate obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Object not found, ID: " + id +
					", type: " + Estate.class.getName());
		}
		return obj;
	}
	
	public List<Estate> findAll() {
		if (repo.findAll().size() == 0) {
			throw new ObjectNotFoundException("List of objects not found, "
					+ "type: " + Estate.class.getName());
		}
		return repo.findAll();
	}
	
	public Estate insert(Estate obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Estate update(Estate obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.delete(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Cannot delete a state that is not empty");
		}
	}

}
