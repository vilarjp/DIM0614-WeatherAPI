package com.weatherapi.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.weatherapi.domain.City;
import com.weatherapi.services.CityService;

import com.weatherapi.interfaces.CityInterface;

/**
 * @class The CityResource class implements the interface CityInterface,
 * to provide the REST methods and routes
 * 
 * default route: http://localhost:8080/cities
 * 
 * @author  João Paulo (vilarjp3@ufrn.edu.br)
 * @author  Luis Eduardo  (cruxiu@ufrn.edu.br)
 * @version 08.10.2018
 */
@RestController
@RequestMapping(value="/cities")
public class CityResource implements CityInterface {
	
	@Autowired
	private CityService service;
	
	/* (non-Javadoc)
	 * GET method to http://localhost:8080/cities/{id}
	 * @return A Http response model with a single city
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<City> find(@PathVariable String id) {
		
		try {
			int foo = Integer.parseInt(id);
			City obj = service.find(foo);
			return ResponseEntity.ok().body(obj);
		} catch(NumberFormatException e) {
			throw new NumberFormatException("Invalid id provided, ID: " + id);
		}
		
	}
	
	/* (non-Javadoc)
	 * GET method to http://localhost:8080/cities
	 * @return A RestTemplate HttpEntity model with a list of all cities
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<City>> findAll() {
		List<City> list = service.searchAll();
		return ResponseEntity.ok().body(list);
		
	}
	
	/* (non-Javadoc)
	 * POST method to http://localhost:8080/cities
	 * @param obj A City object that represents a new city
	 * @return A RestTemplate HttpEntity model with a URI with the new city ID
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody City obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	/* (non-Javadoc)
	 * PUT method to http://localhost:8080/cities/{id} 
	 * @param obj A Estate object that represents new city infos
	 * @param id The id of the city that will be updated
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	@CrossOrigin(origins = "*")
	public ResponseEntity<Void> update(@Valid @RequestBody City obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	/* (non-Javadoc)
	 * DELETE method to http://localhost:8080/cities/{id} 
	 * @param id The id of the city that will deleted
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	@CrossOrigin(origins = "*")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		
		try {
			int foo = Integer.parseInt(id);
			service.delete(foo);
			return ResponseEntity.noContent().build();
		} catch(NumberFormatException e) {
			throw new NumberFormatException("Invalid id provided, ID: " + id);
		}
		
	}

}
