package com.weatherapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weatherapi.domain.Categoria;
import com.weatherapi.repositories.CategoriaRepository;
import com.weatherapi.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Categoria obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado, ID: " + id +
					", tipo: " + Categoria.class.getName());
		}
		return obj;
	}

}
