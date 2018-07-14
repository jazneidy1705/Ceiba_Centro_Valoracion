package com.bolsadeideas.springboot.app.models.service;

import java.util.List;
import com.bolsadeideas.springboot.app.models.entity.Reclamacion;

public interface IReclamacionService {
	
	public List<Reclamacion> findAll();

	public void save(Reclamacion reclamacion);
	
	public Reclamacion  findOne(Long id);
	
	public void delete(Long id);


}
