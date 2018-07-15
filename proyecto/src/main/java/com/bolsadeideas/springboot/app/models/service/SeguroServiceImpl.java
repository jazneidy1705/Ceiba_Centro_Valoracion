package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.dao.IClienteDao;
import com.bolsadeideas.springboot.app.models.dao.ISeguroDao;
import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.entity.Seguro;

@Service
public class SeguroServiceImpl implements ISeguroService {
	
	@Autowired
	private ISeguroDao seguroDao;	
	
	@Override
	@Transactional(readOnly = true)
	public List<Seguro> findAll() {
		// TODO Auto-generated method stub
		return (List<Seguro>) seguroDao.findAll();
	}

	@Override
	public void save(Seguro seguro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seguro findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
