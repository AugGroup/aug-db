package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.dto.LanguageDto;
import com.aug.hrdb.entities.Language;



public interface LanguageService {

	public void create(Language language);
	public void update(Language language);
	public void delete(Language language);
	public Language find(Integer Id);
	public List<Language> findAll();
	
	public void deleteById(Integer id);
	//public List<Employee> findByCriteria(Employee employee);
	
	public List<LanguageDto> findLanguagesById(Integer id);
	public LanguageDto findLanguages(Integer id);
	
}
