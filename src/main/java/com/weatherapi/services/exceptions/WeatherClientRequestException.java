package com.weatherapi.services.exceptions;

public class WeatherClientRequestException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public WeatherClientRequestException(String msg) {
		super(msg);
	}
	
	public WeatherClientRequestException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
