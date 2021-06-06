package com.apirest.dao.dto.app.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.dao.dto.app.dao.IClienteDao;
import com.apirest.dao.dto.app.dto.ClienteDto;
import com.apirest.dao.dto.app.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService<ClienteDto, Integer> {

	@Autowired
	private IClienteDao clienteDao;

	@Override
	public List<ClienteDto> list() {
		LinkedList<ClienteDto> dto = new LinkedList<>();

		clienteDao.findAll().forEach(x -> {
			dto.add(ClienteDto.fromEntidad(x));
		});

		return dto;
	}

	@Override
	public ClienteDto create(ClienteDto t) {

		Cliente cliDao = clienteDao.save(ClienteDto.fromDto(t));

		if (t.getIdCliente() == null) {
			t.setIdCliente(cliDao.getIdCliente());
		}

		return t;
	}

	@Override
	public ClienteDto findById(Integer i) {
		Cliente clienteEntity = clienteDao.findById(i).orElse(null);

		if (clienteEntity == null) {
			return null;
		}

		ClienteDto dto = ClienteDto.fromEntidad(clienteEntity);

		return dto;
	}

	@Override
	public void delete(Integer i) {
		clienteDao.deleteById(i);
	}

}
