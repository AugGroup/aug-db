package com.aug.hrdb.services.impl;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.SkillLanguage;
import com.aug.hrdb.repositories.SkillLanguageRepository;
import com.aug.hrdb.services.SkillLanguageService;




@Service
@Transactional
public class SkillLanguageServiceImpl implements SkillLanguageService{

	@Autowired
	private SkillLanguageRepository skillLanguageRepository;
	/*@Autowired
	private EmployeeService employeeService;*/

	@Override
	public void create(SkillLanguage skillLanguage) {
		skillLanguageRepository.create(skillLanguage);
		
	}

	@Override
	public void update(SkillLanguage skillLanguage) {
		skillLanguageRepository.update(skillLanguage);
		
	}

	@Override
	public void delete(SkillLanguage skillLanguage) {
		skillLanguageRepository.delete(skillLanguage);
		
	}

	@Override
	public SkillLanguage find(Integer Id) {
		
		return skillLanguageRepository.find(Id);
	}

	@Override
	public List<SkillLanguage> findAll() {
		// TODO Auto-generated method stub
		return skillLanguageRepository.findAll();
	}

	

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		 skillLanguageRepository.deleteById(id);
	}

	
	
	
	

	
}
