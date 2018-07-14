package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.dao.IClienteDao;
import com.bolsadeideas.springboot.app.models.dao.IInmuebleDao;
import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.entity.Inmueble;

@Service
public class InmuebleServiceImpl implements IInmuebleService {

	@Autowired
	private IInmuebleDao inmuebleDao;

	@Override
	@Transactional(readOnly = true)
	public List<Inmueble> findAll() {
		return (List<Inmueble>) inmuebleDao.findAll();
	}

	@Override
	@Transactional
	public void save(Inmueble inmueble) {
		inmuebleDao.save(inmueble);
	}

	@Override
	@Transactional(readOnly = true)
	public Inmueble findOne(Long id) {
		return inmuebleDao.findOne(id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		inmuebleDao.delete(id);
	}
}
