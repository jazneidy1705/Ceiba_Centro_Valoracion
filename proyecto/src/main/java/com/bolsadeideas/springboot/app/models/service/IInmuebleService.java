package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import com.bolsadeideas.springboot.app.models.entity.Inmueble;

public interface IInmuebleService {

	List<Inmueble> findAll();

	void save(Inmueble inmueble);

	Inmueble findOne(Long id);

	void delete(Long id);

	
}
