package com.weatherapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weatherapi.domain.City;

/**
 * @class The CityRepository interface extends the JpaRepository that gives
 * methods to access and manipulate the database
 *
 * @author  João Paulo (vilarjp3@ufrn.edu.br)
 * @author  Luis Eduardo  (cruxiu@ufrn.edu.br)
 * @version 08.10.2018
 */

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
		
}
