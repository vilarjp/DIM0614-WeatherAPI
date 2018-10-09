package com.weatherapi.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.weatherapi.domain.City;

/**
 * @class The CityInterface interface specifies the methods to provide 
 * routes responses about cities to the client
 *
 * @author  João Paulo (vilarjp3@ufrn.edu.br)
 * @author  Luis Eduardo  (cruxiu@ufrn.edu.br)
 * @version 08.10.2018
 */

public interface CityInterface {

	/**
	 * Get the city given id of an city.
	 * 
	 * @param id A String that represents the id of the city.
	 * @return A ResponseEntity that represents a http response with the city object.
	 */
	public ResponseEntity<City> find(String id);
	
	/**
	 * Get a list of all cities.
	 * 
	 * @return A ResponseEntity that represents a http response with a list of objects
	 *  with all cities.
	 */
	public ResponseEntity<List<City>> findAll();
	
	/**
	 * Insert a new city into the database
	 * 
	 * @param obj city object that represents the city.
	 * @return A ResponseEntity that represents a http response.
	 */
	public ResponseEntity<Void> insert(City obj);
	
	/**
	 * Update the city given an city object.
	 * 
	 * @param obj city object that represents the city.
	 * @param id A Integer that represents the id of the city.
	 * @return A ResponseEntity that represents a http response.
	 */
	public ResponseEntity<Void> update(City obj, Integer id);
	
	/**
	 * Delete the city given a id of an city
	 * 
	 * @param id A Integer that represents the id of the city.
	 * @return A ResponseEntity that represents a http response.
	 */
	public ResponseEntity<Void> delete(Integer id);
	
}
