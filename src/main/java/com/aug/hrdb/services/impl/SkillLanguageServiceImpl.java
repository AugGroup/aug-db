package com.aug.hrdb.services.impl;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.SkillLanguage;
import com.aug.hrdb.repositories.SkillLanguageRepositories;
import com.aug.hrdb.services.SkillLanguageService;




@Service
@Transactional
public class SkillLanguageServiceImpl implements SkillLanguageService{

	@Autowired
	private SkillLanguageRepositories skillLanguageRepositories;
	/*@Autowired
	private EmployeeService employeeService;*/

	@Override
	public void create(SkillLanguage skillLanguage) {
		skillLanguageRepositories.create(skillLanguage);
		
	}

	@Override
	public void update(SkillLanguage skillLanguage) {
		skillLanguageRepositories.update(skillLanguage);
		
	}

	@Override
	public void delete(SkillLanguage skillLanguage) {
		skillLanguageRepositories.delete(skillLanguage);
		
	}

	@Override
	public SkillLanguage find(Integer Id) {
		
		return skillLanguageRepositories.find(Id);
	}

	@Override
	public List<SkillLanguage> findAll() {
		// TODO Auto-generated method stub
		return skillLanguageRepositories.findAll();
	}

	

	@Override
	public SkillLanguage deleteById(Integer id) {
		// TODO Auto-generated method stub
		return skillLanguageRepositories.deleteById(id);
	}

	
	
	
	

	
}
