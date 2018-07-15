package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.entity.Seguro;

public interface ISeguroService {
	
	public List<Seguro> findAll();

	public void save(Seguro seguro);
	
	public Seguro findOne(Long id);
	
	public void delete(Long id);
	

}
