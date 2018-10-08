package com.weatherapi.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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
import com.weatherapi.dto.EstateDTO;
import com.weatherapi.services.EstateService;
import com.weatherapi.services.exceptions.ObjectNotFoundException;

@RestController
@RequestMapping(value="/estates")
public class EstateResource {
	
	@Autowired
	private EstateService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Estate> find(@PathVariable String id) {
		
		try {
			int foo = Integer.parseInt(id);
			Estate obj = service.find(foo);
			return ResponseEntity.ok().body(obj);
		} catch(Exception e) {
			throw new ObjectNotFoundException("Estate not found, ID: " + id +
					", type: " + Estate.class.getName());
		}		
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Estate>> findAll() {
		List<Estate> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}	

	@RequestMapping(value="/test", method=RequestMethod.GET)
	public ResponseEntity<List<EstateDTO>> findAllTest() {
		List<Estate> list = service.findAll();
		List<EstateDTO> listDto = list.stream().map(obj -> new EstateDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Estate obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	@CrossOrigin(origins = "*")
	public ResponseEntity<Void> update(@Valid @RequestBody Estate obj, @PathVariable Integer id) {
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
