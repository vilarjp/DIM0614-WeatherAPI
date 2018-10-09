package com.weatherapi.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	@Length(min=4, message="Name must be at least 4 characters")
	private String name;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="estate_id")
	private Estate estate;
	
	private Weather weather;
	
	public City() {
		
	}

	/**
	 * @param id
	 * @param name
	 * @param estate
	 * @param weather
	 */
	public City(Integer id, String name, Estate estate, Weather weather) {
		super();
		this.id = id;
		this.name = name;
		this.estate = estate;
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
	 * @return A estate that represents the estate of the city
	 */
	public Estate getEstate() {
		return estate;
	}

	/**
	 * @param estate A estate that represents the new estate of the city
	 */
	public void setEstate(Estate estate) {
		this.estate = estate;
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
