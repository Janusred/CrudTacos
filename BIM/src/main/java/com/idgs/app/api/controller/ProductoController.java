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
import com.idgs.app.api.models.Producto;
import com.idgs.app.api.service.IService;

@RestController
@RequestMapping("/api/producto")
@CrossOrigin(origins = "*")
public class ProductoController {

	
	@Autowired
	IService<Producto, Producto> prodcutoService;
	
	@PostMapping
	public Map<String, String> guardar(@RequestBody Producto v) {
		prodcutoService.guardar(v);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "producto ingresado");
		return respuesta;
	}
	
	@GetMapping
	public List<Producto> listar() {
		return prodcutoService.listar();
	}
	
	@DeleteMapping("/eliminar")
	public Map<String, String> eliminar(@RequestParam(name = "id") Long id) {
		prodcutoService.eliminar(id);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Producto eliminado");
		return respuesta;
	}
	@PutMapping("/actualizar/{id}")
	public Map<String, String> actualizar(@RequestBody Producto a, @PathVariable(name = "id") Long id){
		Optional<Producto> producto = prodcutoService.getById(id);
		if(producto.isPresent()) {
			a.setId(id);
			prodcutoService.guardar(a);
		}else {
			throw new RuntimeException("El producto no existe");
		}
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "producto actualizado correctamente");
		return respuesta;
	}
	
}
