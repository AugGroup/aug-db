package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.entities.Reference;


public interface ReferenceService {

	public void create(Reference reference);
	public void update(Reference reference);
	public void delete(Reference reference);
	public Reference findById(Integer id);
	public List<Reference> findAll();
	public List<Reference> findByCriteria(Reference reference);
	public void deleteById(Integer id);
}
