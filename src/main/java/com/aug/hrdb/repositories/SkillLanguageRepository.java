package com.aug.hrdb.repositories;


import java.util.List;

import com.aug.hrdb.dto.SkillLanguageDto;
import com.aug.hrdb.entities.SkillLanguage;



public interface SkillLanguageRepository extends GenericRepository<SkillLanguage,Integer>{
	
	
	//public List<Employee> findByCriteria(Employee employee);
	

	public List<SkillLanguageDto> listSkillLanguageByEmployee(Integer id);

}
