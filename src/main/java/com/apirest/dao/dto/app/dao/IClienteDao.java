package com.apirest.dao.dto.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.apirest.dao.dto.app.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Integer> {

}
