package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.dao.IClienteDao;
import com.bolsadeideas.springboot.app.models.dao.IReclamacionDao;
import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.entity.Reclamacion;

@Service
public class ReclamacionServiceImpl implements IReclamacionService {

	@Autowired
	private IReclamacionDao reclamacionDao;
	

	@Override
	@Transactional(readOnly = true)
	public List<Reclamacion> findAll() {
		return (List<Reclamacion>) reclamacionDao.findAll();
	}

	@Override
	@Transactional
	public void save(Reclamacion reclamacion) {
	 reclamacionDao.save(reclamacion);
		
	}

	@Override
	public Reclamacion findOne(Long id) {
		return reclamacionDao.findOne(id);
	}

	@Override
	public void delete(Long id) {
		reclamacionDao.delete(id);
		
	}
	
	
	
}
