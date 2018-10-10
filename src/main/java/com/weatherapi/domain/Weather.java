package com.weatherapi.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @class The Weather class implements a weather entity
 * 
 * @author  João Paulo (vilarjp3@ufrn.edu.br)
 * @author  Luis Eduardo  (cruxiu@ufrn.edu.br)
 * @version 08.10.2018
 */

@Entity
public class Weather implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private double temperature;
	private double humidity;
	private double pressure;

	public Weather() {
		
	}
	
	/**
	 * @param id
	 * @param temperature
	 * @param humidity
	 * @param pressure
	 */
	public Weather(Integer id, double temperature, double humidity, double pressure) {
		super();
		this.id = id;
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
	}

	/**
	 * @return A Integer that represents the id of the weather
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id A Integer that represents the new id of the weather
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return A Integer that represents the tempetature of the weather
	 */
	public double getTemperature() {
		return temperature;
	}

	/**
	 * @param id A Integer that represents the new temperature of the weather
	 */
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	/**
	 * @return A Integer that represents the humidty of the weather
	 */
	public double getHumidity() {
		return humidity;
	}

	/**
	 * @param id A Integer that represents the new humidity of the weather
	 */
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	/**
	 * @return A Integer that represents the pressure of the weather
	 */
	public double getPressure() {
		return pressure;
	}

	/**
	 * @param id A Integer that represents the new pressure of the weather
	 */
	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	@Override
	public int hashCode() {
		final double prime = 31;
		double result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return (int) result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Weather other = (Weather) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
	
}
