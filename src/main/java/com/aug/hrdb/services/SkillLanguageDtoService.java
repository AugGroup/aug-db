package com.aug.hrdb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.LanguageDto;
import com.aug.hrdb.repositories.LanguageRepository;


@Service(value="skillLanguageDtoService")
@Transactional
public class SkillLanguageDtoService {

	@Autowired
	private LanguageRepository languageRepository;
	
	
	public List<LanguageDto> listSkillLanguage(Integer id){
		return  languageRepository.listSkillLanguageByEmployee(id);
	}
	
}
