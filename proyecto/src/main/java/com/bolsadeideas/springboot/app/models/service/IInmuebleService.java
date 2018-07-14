package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import com.bolsadeideas.springboot.app.models.entity.Inmueble;

public interface IInmuebleService {

	public List<Inmueble> findAll();

	public void save(Inmueble inmueble);

	public Inmueble findOne(Long id);

	public void delete(Long id);
}
