package com.aug.hrdb.repositories;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;

public interface GenericRepository<E, I extends Serializable> {
	public Session getCurrentSession();

	public List<E> findAll() throws DataAccessException;

	public E find(I id);

	public void create(E e);

	public void update(E e);

	public void delete(E e);

	public void deleteByApplicantId(I id);

	public void flush();
}
