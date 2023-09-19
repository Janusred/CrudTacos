package com.idgs.app.api.service;


import java.util.List;
import java.util.Optional;
public interface IService<T,S>{

	
	
	
	List<T> listar();

	Optional<T> getById(Long id);

	void guardar(S t);

	void eliminar(Long id);
}
