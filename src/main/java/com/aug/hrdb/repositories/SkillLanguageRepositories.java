package com.aug.hrdb.repositories;


import java.util.List;

import com.aug.hrdb.dto.SkillLanguageDto;
import com.aug.hrdb.entities.SkillLanguage;



public interface SkillLanguageRepositories extends GenericRepository<SkillLanguage,Integer>{
	
	
	//public List<Employee> findByCriteria(Employee employee);
	public SkillLanguage deleteById(Integer id);

	public List<SkillLanguageDto> listSkillLanguageByEmployee(Integer id);

}
