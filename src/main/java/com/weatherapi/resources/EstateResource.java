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

import com.weatherapi.domain.Estate;
import com.weatherapi.interfaces.EstateInterface;
import com.weatherapi.services.EstateService;

/**
 * @class The CityResource class implements the interface CityInterface,
 * to provide the REST methods and routes
 * 
 * default route: http://localhost:8080/estates
 * 
 * @author  João Paulo (vilarjp3@ufrn.edu.br)
 * @author  Luis Eduardo  (cruxiu@ufrn.edu.br)
 * @version 08.10.2018
 */
@RestController
@RequestMapping(value="/estates")
public class EstateResource implements EstateInterface {
	
	@Autowired
	private EstateService service;
	
	/* (non-Javadoc)
	 * GET method to http://localhost:8080/estates/{id}
	 * @return A RestTemplate HttpEntity model with a single estate
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Estate> find(@PathVariable String id) {
		
		try {
			int foo = Integer.parseInt(id);
			Estate obj = service.find(foo);
			return ResponseEntity.ok().body(obj);
		} catch(NumberFormatException e) {
			throw new NumberFormatException("Invalid id provided, ID: " + id);
		}		
		
	}
	
	/* (non-Javadoc)
	 * GET method to http://localhost:8080/estates
	 * @return A RestTemplate HttpEntity model with a list of all estates
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Estate>> findAll() {
		List<Estate> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}	
	
	/* (non-Javadoc)
	 * POST method to http://localhost:8080/estates
	 * @param obj An Estate object that represents a new estate
	 * @return A RestTemplate HttpEntity model with a URI with the new estate ID
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Estate obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	/* (non-Javadoc)
	 * PUT method to http://localhost:8080/estates/{id} 
	 * @param obj A Estate object that represents new estate infos
	 * @param id The id of the estate that will be updated
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	@CrossOrigin(origins = "*")
	public ResponseEntity<Void> update(@Valid @RequestBody Estate obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	/* (non-Javadoc)
	 * DELETE method to http://localhost:8080/estates/{id} 
	 * @param id The id of the estate that will deleted
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	@CrossOrigin(origins = "*")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
