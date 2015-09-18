package com.aug.hrdb.services.impl;


import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.LanguageDto;
import com.aug.hrdb.entities.Language;
import com.aug.hrdb.repositories.LanguageRepository;
import com.aug.hrdb.services.LanguageService;




@Service
@Transactional
public class LanguageServiceImpl implements LanguageService{

	@Autowired
	private LanguageRepository languageRepository;
	/*@Autowired
	private EmployeeService employeeService;*/

	@Override
	public void create(Language language) {
		languageRepository.create(language);
		
	}

	@Override
	public void update(Language language) {
		languageRepository.update(language);
		
	}

	@Override
	public void delete(Language language) {
		languageRepository.delete(language);
		
	}

	@Override
	public Language find(Integer Id) {
		
		return languageRepository.find(Id);
	}

	@Override
	public List<Language> findAll() {
		// TODO Auto-generated method stub
		return languageRepository.findAll();
	}

	

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		 languageRepository.deleteById(id);
	}

	@Override
	public List<LanguageDto> findLanguagesById(Integer id) {
		List<LanguageDto> languageses = languageRepository.findLanguagesById(id);
		return languageses;
	}

	@Override
	public LanguageDto findLanguages(Integer id) {
		LanguageDto languages = languageRepository.findByLanguagesId(id);
		return languages;
	}


	
	
	
	

	
}
