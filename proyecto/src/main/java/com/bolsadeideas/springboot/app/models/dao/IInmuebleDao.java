package com.bolsadeideas.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.app.models.entity.Inmueble;

public interface IInmuebleDao extends CrudRepository<Inmueble, Long> {

}
