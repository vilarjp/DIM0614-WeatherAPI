package com.weatherapi.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.weatherapi.domain.Estate;

/**
 * @class The EstateInterface interface specifies the methods to provide 
 * routes responses about estates to the client
 *
 * @author  João Paulo (vilarjp3@ufrn.edu.br)
 * @author  Luis Eduardo  (cruxiu@ufrn.edu.br)
 * @version 08.10.2018
 */

public interface EstateInterface {
	
	/**
	 * Get the estate given id of an estate.
	 * 
	 * @param id A String that represents the id of the estate.
	 * @return A ResponseEntity that represents a http response with the estate object.
	 */
	public ResponseEntity<Estate> find(String id);
	
	/**
	 * Get a list of all estates.
	 * 
	 * @return A ResponseEntity that represents a http response with a list of objects
	 *  with all estates.
	 */
	public ResponseEntity<List<Estate>> findAll();
	
	/**
	 * Insert a new estate into the database
	 * 
	 * @param obj Estate object that represents the estate.
	 * @return A ResponseEntity that represents a http response.
	 */
	public ResponseEntity<Void> insert(Estate obj);
	
	/**
	 * Update the estate given an estate object.
	 * 
	 * @param obj Estate object that represents the estate.
	 * @param id A Integer that represents the id of the estate.
	 * @return A ResponseEntity that represents a http response.
	 */
	public ResponseEntity<Void> update(Estate obj, Integer id);
	
	/**
	 * Delete the estate given a id of an estate
	 * 
	 * @param id A Integer that represents the id of the estate.
	 * @return A ResponseEntity that represents a http response.
	 */
	public ResponseEntity<Void> delete(Integer id);

}
