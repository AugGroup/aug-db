package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.dto.FamilyDto;
import com.aug.hrdb.entities.Family;


public interface FamilyRepository extends GenericRepository<Family, Integer> {

	 public List<Family> findFamilyByEmployeeId(Integer Id);
	 //public Employee findEmployeeById(Integer Id);
	 public Family findLastFamily(Integer Id);
	 
	 public void saveByNameQuery(FamilyDto family);
	 public void updateByNameQuery(FamilyDto family);
	 public void deleteByNameQuery(FamilyDto family);
	 public List<FamilyDto> findFamilyList(Integer id);
	 

}

