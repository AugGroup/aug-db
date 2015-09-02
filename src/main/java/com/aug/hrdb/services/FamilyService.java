package com.aug.hrdb.services;

import java.util.List;


import com.aug.hrdb.dto.FamilyDto;
import com.aug.hrdb.entities.Family;


public interface FamilyService {
	
	public void create(Family empFamily);
	public void update(Family empFamily);
	public void delete(Family empFamily);
	public Family find(Integer Id);
	public List<Family> findAll();
	
	public List<Family> findFamilyByEmployeeId(Integer Id);
	
	
    //public Employee findEmployeeById(Integer Id);
    public Family findLastFamily(Integer Id);
    public void saveByNameQuery(FamilyDto family);
    public void updateByNameQuery(FamilyDto family);
    public void deleteByNameQuery(FamilyDto family);
    public void createFindMasRelationAndEmployee(FamilyDto familyDto);
    public FamilyDto findForInitEdit(FamilyDto family);
    public void updateFindMasRelationAndEmployee(FamilyDto familyDto);


}
