package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.dto.FamilyDto;
import com.aug.hrdb.entities.Family;


public interface FamilyRepository extends GenericRepository<Family, Integer> {
	
	
	 public void create(Family family);
	 public void update(Family family);
	 public void delete(Family family);
	 public Family find(Integer Id);
	 public List<Family> findAll();
	 public void deleteById(Integer id);
	

	 public List<Family> findFamilyByApplicantId(Integer Id);
	 public Family findLastFamily(Integer Id);
	 public void deleteByNameQuery(FamilyDto family);
	
	 
	 public List<FamilyDto> findFamilyList(Integer id); 
	 public List<FamilyDto> findFamilyById(Integer id);
	 
	 public FamilyDto findFamily(Integer id);
	 

}

