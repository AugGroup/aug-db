package com.aug.hrdb.services;

import java.util.List;



import com.aug.hrdb.dto.ApplicantDto;
import com.aug.hrdb.dto.LanguageDto;
import com.aug.hrdb.entities.Language;



public interface LanguageService {

	public void create(Language language);
	public void update(Language language);
	public void delete(Language language);
	public Language find(Integer Id);
	public List<Language> findAll();
	
	public void deleteById(Integer id);
	
	
	public void saveByFindEmployee(Integer employeeId,LanguageDto skillLanguage);
	public LanguageDto findLanguageById(Integer id);
	public void updateSetLanguage(LanguageDto skillLanguage);
	
	public List<LanguageDto> findLanguagesById(Integer id);
	public LanguageDto findLanguages(Integer id);
	public List<LanguageDto> findLanguageName(String languageName);
	
}
