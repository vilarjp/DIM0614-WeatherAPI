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

@RestController
@RequestMapping(value="/cities")
public class CityResource {
	
	@Autowired
	private CityService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		City obj = service.search(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<City> list = new ArrayList<>();
		list = service.searchAll();
		
		return ResponseEntity.ok().body(list);
		
	}

}
