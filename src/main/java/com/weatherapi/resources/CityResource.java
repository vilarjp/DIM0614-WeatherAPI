package com.weatherapi.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.weatherapi.domain.City;
import com.weatherapi.services.CityService;
import com.weatherapi.services.exceptions.ObjectNotFoundException;

@RestController
@RequestMapping(value="/cities")
public class CityResource {
	
	@Autowired
	private CityService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<City> find(@PathVariable String id) {
		
		try {
			int foo = Integer.parseInt(id);
			City obj = service.find(foo);
			return ResponseEntity.ok().body(obj);
		} catch(Exception e) {
			throw new ObjectNotFoundException("Object not found, ID: " + id +
					", type: " + City.class.getName());
		}
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<City>> findAll() {
		List<City> list = new ArrayList<>();
		list = service.searchAll();
		
		return ResponseEntity.ok().body(list);
		
	}

}
