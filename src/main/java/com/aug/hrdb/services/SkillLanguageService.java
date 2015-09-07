package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.entities.SkillLanguage;



public interface SkillLanguageService {

	public void create(SkillLanguage skillLanguage);
	public void update(SkillLanguage skillLanguage);
	public void delete(SkillLanguage skillLanguage);
	public SkillLanguage find(Integer Id);
	public List<SkillLanguage> findAll();
	
	public void deleteById(Integer id);
	//public List<Employee> findByCriteria(Employee employee);
	
}
