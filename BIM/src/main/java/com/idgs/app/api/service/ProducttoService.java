package com.idgs.app.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idgs.app.api.dao.IClienteDao;
import com.idgs.app.api.dao.IProductoDao;
import com.idgs.app.api.models.Cliente;
import com.idgs.app.api.models.Producto;
@Service
public class ProducttoService implements IService<Producto, Producto> {

	
	
	@Autowired
	private IProductoDao productoDao;
	@Override
	public List<Producto> listar() {
		// TODO Auto-generated method stub
		return (List<Producto>) this.productoDao.findAll();
	}

	@Override
	public Optional<Producto> getById(Long id) {
		// TODO Auto-generated method stub
		return this.productoDao.findById(id);
	}

	@Override
	public void guardar(Producto t) {
		// TODO Auto-generated method stub
		this.productoDao.save(t);
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		this.productoDao.deleteById(id);
	}

}
