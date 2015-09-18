package com.aug.hrdb.repositories;


import java.util.List;

import com.aug.hrdb.dto.LanguageDto;
import com.aug.hrdb.entities.Language;



public interface LanguageRepository extends GenericRepository<Language,Integer>{
	
	
	//public List<Employee> findByCriteria(Employee employee);
	

	public List<LanguageDto> listSkillLanguageByEmployee(Integer id);
	
	public List<LanguageDto> findLanguagesById(Integer id);
	
	public LanguageDto findByLanguagesId(Integer id);

}
