package com.aug.hrdb.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

public interface GenericService<E, I extends Serializable> {

	public List<E> findAll() throws DataAccessException;

	public E findById(I id);

	public void create(E e);

	public void update(E e);

	public void delete(E e);

	public void deleteById(I id);
	
}