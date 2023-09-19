package com.idgs.app.api.dao;

import org.springframework.data.repository.CrudRepository;

import com.idgs.app.api.models.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long>{

}
