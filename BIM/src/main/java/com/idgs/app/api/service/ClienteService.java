package com.idgs.app.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.idgs.app.api.dao.IClienteDao;
import com.idgs.app.api.models.Cliente;
@Service
public class ClienteService implements IService<Cliente, Cliente> {

	
	@Autowired
	private IClienteDao clienteDao;
	
	@Override
	public List<Cliente> listar() {
		// TODO Auto-generated method stub
		return (List<Cliente>) this.clienteDao.findAll();
	}

	@Override
	public Optional<Cliente> getById(Long id) {
		// TODO Auto-generated method stub
		return this.clienteDao.findById(id);
	}

	@Override
	public void guardar(Cliente t) {
		// TODO Auto-generated method stub
		this.clienteDao.save(t);
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		this.clienteDao.deleteById(id);
	}

}
