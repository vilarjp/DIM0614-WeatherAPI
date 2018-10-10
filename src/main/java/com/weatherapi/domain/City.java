package com.weatherapi.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @class The City class implements a city entity
 * 
 * @author  João Paulo (vilarjp3@ufrn.edu.br)
 * @author  Luis Eduardo  (cruxiu@ufrn.edu.br)
 * @version 08.10.2018
 */

@Entity
public class City implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Auto generates the ID of the city
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * Validate the fields when a city is created
	 */
	@NotEmpty(message="Name cannot be empty")
	@Length(min=2, message="Name must be at least 2 characters")
	private String name;
	
	private Weather weather;
	
	public City() {
		
	}

	/**
	 * @param id
	 * @param name
	 */
	public City(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/**
	 * @param id
	 * @param name
	 * @param weather
	 */
	public City(Integer id, String name, Weather weather) {
		super();
		this.id = id;
		this.name = name;
		this.weather = weather;
	}

	/**
	 * @return A integer that represents the id of the city
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id A integer that represents the new id of the city
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return A string that represents the name of the city
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name A string that represents the new name of the city
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return A weather object that represents the weather of the city
	 */
	public Weather getWeather() {
		return weather;
	}

	/**
	 * @param weather A weather object that represents the new weather of the city
	 */
	public void setWeather(Weather weather) {
		this.weather = weather;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	

}
