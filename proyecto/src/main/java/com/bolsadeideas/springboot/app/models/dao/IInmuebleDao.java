package com.bolsadeideas.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.app.models.entity.Inmueble;

//a
public interface IInmuebleDao extends CrudRepository<Inmueble, Long> {

}
