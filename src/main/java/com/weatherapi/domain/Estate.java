package com.weatherapi.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @class The estate class implements a estate entity
 * 
 * @author  João Paulo (vilarjp3@ufrn.edu.br)
 * @author  Luis Eduardo  (cruxiu@ufrn.edu.br)
 * @version 08.10.2018
 */

@Entity
public class Estate implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Auto generates the ID of the estate
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * Validate the fields when a estate is created
	 */
	@NotEmpty(message="Name cannot be empty")
	@Length(min=4, message="Name must be at least 4 characters")
	private String name;
	
	@NotEmpty(message="Abbreviation cannot be empty")
	@Length(min=2, message="Abbreviation must be at least 2 characters")
	private String abbreviation;
	
	@JsonManagedReference
	@OneToMany(mappedBy="estate")
	private List<City> cities = new ArrayList<>();
	
	public Estate() {
		
	}

	/**
	 * @param id
	 * @param name
	 * @param abbreviation
	 */
	public Estate(Integer id, String name, String abbreviation) {
		super();
		this.id = id;
		this.name = name;
		this.abbreviation = abbreviation;
	}
	
	/**
	 * @return A integer that represents the id of the estate
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id A integer that represents the new id of the estate
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return A string that represents the name of the estate
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name A string that represents the new name of the estate
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return A string that represents the abbreviation of the estate
	 */
	public String getAbbreviation() {
		return abbreviation;
	}

	/**
	 * @param abbreviation A string that represents the new abbreviation of the estate
	 */
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	/**
	 * @return A list with all cities of the estate
	 */
	public List<City> getCities() {
		return cities;
	}

	/**
	 * @param A list that represents the new list of cities
	 */
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	
	public void addCity(City obj) {
		this.cities.add(obj);
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
		Estate other = (Estate) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
