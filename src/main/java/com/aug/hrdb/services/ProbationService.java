package com.aug.hrdb.services;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.aug.hrdb.entities.Probation;


public interface ProbationService {

	public List<Probation> findAll() throws DataAccessException;

	public Probation find(Integer id);

	public abstract void create(Probation probation);

	public abstract void update(Probation probation);

	public abstract void delete(Probation probation);
	
	public List<Probation> findByCriteria(Probation probation);
	
	public void deleteById(Integer id);
}
