package com.apirest.dao.dto.app.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.apirest.dao.dto.app.entity.Cliente;

public class ClienteDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idCliente;
	
	@NotEmpty
	@Size(min = 4)
	private String nombre;
	
	@NotEmpty
	@Size(min = 4)
	private String apellido;
	
	@NotNull
	private Short edad;

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Short getEdad() {
		return edad;
	}

	public void setEdad(Short edad) {
		this.edad = edad;
	}
	
	public static ClienteDto fromEntidad(Cliente entidad) {
		ClienteDto dto = new ClienteDto();
		
		dto.setIdCliente(entidad.getIdCliente());
		dto.setNombre(entidad.getNombre());
		dto.setApellido(entidad.getApellido());
		dto.setEdad(entidad.getEdad());
		
		return dto;
	}
	
	public static Cliente fromDto(ClienteDto dto) {
		Cliente entidad = new Cliente();
		
		entidad.setIdCliente(dto.getIdCliente());
		entidad.setNombre(dto.getNombre());
		entidad.setApellido(dto.getApellido());
		entidad.setEdad(dto.getEdad());
		
		return entidad;
	}

}
