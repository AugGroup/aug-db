package com.aug.hrdb.repositories;


import java.util.List;

import com.aug.hrdb.dto.LanguageDto;
import com.aug.hrdb.entities.Language;



public interface LanguageRepository extends GenericRepository<Language,Integer>{

	
	public List<LanguageDto> findLanguagesById(Integer id);	
	public LanguageDto findByLanguagesId(Integer id);
	public List<LanguageDto> listLanguageByEmployee(Integer id);
	public Language findIdJoinEmployee(Integer id); 
	public List<LanguageDto> findLanguageName(String languageName);
}
