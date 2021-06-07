package com.apirest.dao.dto.app.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.dao.dto.app.dto.ClienteDto;
import com.apirest.dao.dto.app.services.IClienteService;

@RestController
@RequestMapping("/api")
public class ClienteRestController {

	@Autowired
	IClienteService<ClienteDto, Integer> clienteService;

	@GetMapping("/clientes")
	public List<ClienteDto> index() {
		return clienteService.list();
	}

	@PostMapping("/clientes")
	public ResponseEntity<?> create(@Valid @RequestBody ClienteDto dto, BindingResult result) {
		Map<String, Object> response = new HashMap<>();
		ClienteDto clienteNew = null;
		
		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			clienteNew = clienteService.create(dto);
		} catch (DataAccessException e) {
			response.put("mensaje", "Hay un error en la BD");
			response.put("error", e.getMostSpecificCause().getMessage());

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El cliente ah sido creado con exito");
		response.put("cliente", clienteNew);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@GetMapping("/clientes/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id) {
		ClienteDto cliente = null;
		Map<String, Object> response = new HashMap<>();

		try {
			cliente = clienteService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Hay un error en la BD");
			response.put("error", e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (cliente == null) {
			response.put("mensaje", "El cliente con ID: ".concat(id.toString()).concat(" no existe en la BD"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<ClienteDto>(cliente, HttpStatus.OK);
	}

	@PutMapping("/clientes/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody ClienteDto dto, BindingResult result, @PathVariable Integer id) {
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		ClienteDto clienteActual = clienteService.findById(id);
		ClienteDto clienteUpdate = null;

		try {
			clienteActual.setIdCliente(dto.getIdCliente());
			clienteActual.setNombre(dto.getNombre());
			clienteActual.setApellido(dto.getApellido());
			clienteActual.setEdad(dto.getEdad());

			clienteUpdate = clienteService.create(clienteActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Hay un error en la BD al actualizar el ID " + id);
			response.put("error", e.getMostSpecificCause().getMessage());

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El cliente ah sido actualizado con exito");
		response.put("cliente", clienteUpdate);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		Map<String, Object> response = new HashMap<>();

		try {
			clienteService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Hay un error en la BD");
			response.put("error", e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El cliente con ID: ".concat(id.toString()).concat(" ah sido eliminado"));

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
