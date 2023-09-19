package com.idgs.app.api.dao;

import org.springframework.data.repository.CrudRepository;

import com.idgs.app.api.models.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long> {

}
