package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.entities.MasSpecialty;


public interface MasSpecialtyService {
	
	public List<MasSpecialty> findAll();
	public void create(MasSpecialty specialty);
	public void update(MasSpecialty specialty);
	public void delete(MasSpecialty specialty);
	public MasSpecialty findById(Integer id);
	public List<MasSpecialty> findByCriteria(MasSpecialty specialty);
	public void deleteById(Integer id);

}
