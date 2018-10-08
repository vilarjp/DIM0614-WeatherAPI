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
			throw new ObjectNotFoundException("City not found, ID: " + id +
					", type: " + City.class.getName());
		}
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<City>> findAll() {
		List<City> list = service.searchAll();
		return ResponseEntity.ok().body(list);
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody City obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	@CrossOrigin(origins = "*")
	public ResponseEntity<Void> update(@Valid @RequestBody City obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	@CrossOrigin(origins = "*")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
