package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.entities.MasSpecialty;



public interface MasSpecialtyRepository extends GenericRepository<MasSpecialty, Integer>{
	
	
	public List<MasSpecialty> findByCriteria(MasSpecialty specialty);
	

	

}
