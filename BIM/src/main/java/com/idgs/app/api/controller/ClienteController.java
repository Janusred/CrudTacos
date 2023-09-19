package com.idgs.app.api.controller;

import org.springframework.web.bind.annotation.PutMapping;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.idgs.app.api.models.Cliente;
import com.idgs.app.api.service.IService;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin(origins = "*")
public class ClienteController {

	
	
	@Autowired
	IService<Cliente, Cliente> clienteService;
	
	
	@PostMapping
	public Map<String, String> guardar(@RequestBody Cliente v) {
		clienteService.guardar(v);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "cliente ingresado");
		return respuesta;
	}
	
	@GetMapping
	public List<Cliente> listar() {
		return clienteService.listar();
	}
	
	@DeleteMapping("/eliminar")
	public Map<String, String> eliminar(@RequestParam(name = "id") Long id) {
		clienteService.eliminar(id);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Cliente eliminado");
		return respuesta;
	}
	@PutMapping("/actualizar/{id}")
	public Map<String, String> actualizar(@RequestBody Cliente a, @PathVariable(name = "id") Long id){
		Optional<Cliente> cliente = clienteService.getById(id);
		if(cliente.isPresent()) {
			a.setId(id);
			clienteService.guardar(a);
		}else {
			throw new RuntimeException("El Cliente no existe");
		}
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Estado actualizado correctamente");
		return respuesta;
	}
	
	
}
