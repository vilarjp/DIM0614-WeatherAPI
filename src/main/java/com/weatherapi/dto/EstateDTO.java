package com.weatherapi.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

import com.weatherapi.domain.Estate;

public class EstateDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message="Name cannot be empty")
	private String name;
	
	@NotEmpty(message="Abbreviation cannot be empty")
	private String abbreviation;
	
	public EstateDTO() {
		
	}
	
	public EstateDTO(Estate obj) {
		id = obj.getId();
		name = obj.getName();
		abbreviation = obj.getAbbreviation();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	
}
