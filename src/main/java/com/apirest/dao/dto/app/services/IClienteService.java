package com.apirest.dao.dto.app.services;

import java.util.List;

public interface IClienteService<T, I> {

	public List<T> list();

	public T create(T t);

	public T findById(I i);

	public void delete(I i);

}
