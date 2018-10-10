package com.weatherapi.domain;

import org.openweathermap.api.DataWeatherClient;
import org.openweathermap.api.UrlConnectionDataWeatherClient;
import org.openweathermap.api.model.currentweather.CurrentWeather;
import org.openweathermap.api.query.*;
import org.openweathermap.api.query.currentweather.CurrentWeatherOneLocationQuery;

import com.weatherapi.domain.Weather;

/**
 * @class The OpenWeatherMapSystem class that extends the class UnicastRemoteObject
 * and implements the interface WeatherSystem, to provide meteorological information
 * to be provided on the server side.
 *
 * @author  João Paulo (vilarjp3@ufrn.edu.br)
 * @author  Luis Eduardo  (cruxiu@ufrn.edu.br)
 * @version 29.08.2018
 */

public class OpenWeatherMapSystem {
	
	private static final String API_KEY = "e727e62532fa3bedf05392e295969719";
	
	/**
	* Creates a new OpenWeatherMapSystem object.
	*/
	public OpenWeatherMapSystem() { 
		super(); 
	}
	
	/**
	 * Creates a new CurrentWeatherOneLocationQuery object.
	 * 
	 * @param city A String that represents the name of the city.
	 * @return A CurrentWeatherOneLocationQuery that represents an object containing
	 * information about the given city.
	 * @exception RemoteException Fail at creating the server.
	 */
	public synchronized Weather getWeather(String city) {
		DataWeatherClient client = new UrlConnectionDataWeatherClient(API_KEY);
        CurrentWeatherOneLocationQuery currentWeatherOneLocationQuery = QueryBuilderPicker.pick()
                .currentWeather()                   // get current weather
                .oneLocation()                      // for one location
                .byCityName(city)             		// the cite given as parameter
                .type(Type.ACCURATE)                // with Accurate search
                .language(Language.PORTUGUESE)         // in Portuguese language
                .responseFormat(ResponseFormat.JSON)// with JSON response format
                .unitFormat(UnitFormat.METRIC)      // in metric units
                .build();
        CurrentWeather currentWeather = client.getCurrentWeather(currentWeatherOneLocationQuery);
        Weather weather = new Weather(null, currentWeather.getMainParameters().getTemperature(),
        		currentWeather.getMainParameters().getHumidity(),
        		currentWeather.getMainParameters().getPressure());
        return weather;
	}
	
}
